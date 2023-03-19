package com.alibou.bootcamp.user;

import com.alibou.bootcamp.account.Account;
import com.alibou.bootcamp.account.AccountRequest;
import com.alibou.bootcamp.account.AccountService;
import com.alibou.bootcamp.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;
  private final ObjectsValidator<UserRequest> validator;
  private final UserMapper mapper;
  private final AccountService accountService;

  public Integer create(UserRequest request) {
    validator.validate(request);
    var user = mapper.toUser(request);
    user.setActive(false);
    return repository.save(user).getId();
  }

  public List<UserResponse> findAll() {
    return repository.findAll()
        .stream()
        .map(mapper::toResponse)
        .collect(Collectors.toList());
  }

  public UserResponse findById(Integer id) {
    return repository.findById(id)
        .map(mapper::toResponse)
        .orElseThrow(() -> new EntityNotFoundException("No user found with the ID:: " + id));
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }

  @Transactional(rollbackOn = Exception.class)
  public Integer validateAccount(Integer userId) {
    var user = repository.findById(userId)
        .orElseThrow(() -> new EntityNotFoundException("No user found with the ID for account validation:: " + userId));
    if (user.getAccount() == null) {
      // create a bank account
      var account = AccountRequest.builder()
          .userId(userId)
          .build();
      var savedAccountId = accountService.create(account);
      user.setAccount(
          Account.builder()
              .id(savedAccountId)
              .build()
      );
    }
    user.setActive(true);
    return repository.save(user).getId();
  }

  public Integer invalidateAccount(Integer userId) {
    var user = repository.findById(userId)
        .orElseThrow(() -> new EntityNotFoundException("No user found with the ID for account invalidation:: " + userId));
    user.setActive(false);
    return repository.save(user).getId();
  }
}
