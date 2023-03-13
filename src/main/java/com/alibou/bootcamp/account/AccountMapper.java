package com.alibou.bootcamp.account;

import com.alibou.bootcamp.user.User;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

  public Account toAccount(AccountRequest request) {
    return Account.builder()
        .iban(request.getIban())
        .user(
            User.builder()
                .id(request.getUserId())
                .build()
        )
        .build();
  }
}
