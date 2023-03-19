package com.alibou.bootcamp.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountMapperTest {

  private final AccountMapper mapper = new AccountMapper();

  @Test
  public void should_map_from_account_request_to_Account() {
    var request = AccountRequest.builder()
        .userId(1)
        .build();
    var account = mapper.toAccount(request);
    Assertions.assertNotNull(account);
    Assertions.assertNotNull(account.getUser());
    Assertions.assertEquals(1, account.getUser().getId());
    Assertions.assertNull(account.getIban());
  }

  @Test
  public void should_handle_null_request() {
    var account = mapper.toAccount(null);
    assertNotNull(account);
  }

}