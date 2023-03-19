package com.alibou.bootcamp.account;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final AccountService service;

  @PostMapping
  public Integer save(
      @RequestBody AccountRequest account
  ) {
    return service.create(account);
  }

  @GetMapping
  public ResponseEntity<List<AccountResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{account-id}")
  public ResponseEntity<AccountResponse> findById(
      @PathVariable("account-id") Integer id
  ) {
    return ResponseEntity.ok(service.findById(id));
  }

  @DeleteMapping("/{account-id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(
      @PathVariable("account-id") Integer id
  ) {
    service.delete(id);
  }

}
