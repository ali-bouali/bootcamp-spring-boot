package com.alibou.bootcamp.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.alibou.bootcamp.user.User;
import com.alibou.bootcamp.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceSpringTest {

  @Autowired
  private AccountService service;
  @Autowired
  private UserRepository userRepository;

  @Test
  public void should_create_account() {
    var savedUser = userRepository.save(User.builder().firstname("Ali").build());
    var request = AccountRequest.builder()
        .userId(savedUser.getId())
        .build();

    var id = service.create(request);

    assertEquals(1, id);
  }
}
