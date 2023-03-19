package com.alibou.bootcamp.account;

import com.alibou.bootcamp.exception.OperationNonPermittedException;
import com.alibou.bootcamp.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository repository;
  private final AccountMapper mapper;
  private final ObjectsValidator<AccountRequest> validator;

  public Integer create(AccountRequest accountRequest) {
    validator.validate(accountRequest);
    var account = mapper.toAccount(accountRequest);
    var userHasAlreadyAnAccount = repository.existsByUserId(accountRequest.getUserId());
    if (userHasAlreadyAnAccount) {
      throw new OperationNonPermittedException("The selected user has already an account");
    }
    account.setIban(generateRandomIban());
    return repository.save(account).getId();
  }

  public List<AccountResponse> findAll() {
    return repository.findAll()
        .stream()
        .map(mapper::toResponse)
        .collect(Collectors.toList());
  }

  public AccountResponse findById(Integer id) {
    return repository.findById(id)
        .map(mapper::toResponse)
        .orElseThrow(() -> new EntityNotFoundException("No Account found with the ID:: " + id));
  }

  public void delete(Integer id) {
    // check before delete
    repository.deleteById(id);
  }

  private String generateRandomIban() {
    // generate a random IBAN
    var iban = Iban.random(CountryCode.TN).toFormattedString();
    // check if the iban exists
    if (repository.existsByIban(iban)) {
      // if true --> generate new IBAN
      generateRandomIban();
    }
    // if false (not exists) --> return IBAN
    return iban;
  }
}
