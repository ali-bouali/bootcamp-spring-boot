package com.alibou.bootcamp.account;

import com.alibou.bootcamp.user.User;
import com.alibou.bootcamp.validator.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository repository;
  private final AccountMapper mapper;
  private final ObjectsValidator<AccountRequest> validator;

  public Integer save(AccountRequest accountRequest) {
    validator.validate(accountRequest);
    var account = mapper.toAccount(accountRequest);
    return repository.save(account).getId();
  }
}
