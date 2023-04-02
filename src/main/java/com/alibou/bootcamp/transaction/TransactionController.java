package com.alibou.bootcamp.transaction;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
@Tag(name = "Transactions")
public class TransactionController {
  private final TransactionService service;

  @PostMapping
  public Integer save(
      @RequestBody TransactionRequest transaction
  ) {
    return service.create(transaction);
  }

  @GetMapping("/user/{user-id}")
  public ResponseEntity<List<TransactionResponse>> findAll(
      @PathVariable("user-id") Integer id
  ) {
    return ResponseEntity.ok(service.findAllByUser(id));
  }
}
