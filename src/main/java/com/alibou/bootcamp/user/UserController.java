package com.alibou.bootcamp.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @PostMapping
  public Integer save(
      @RequestBody UserRequest userRequest
  ) {
    return service.create(userRequest);
  }

  @GetMapping
  public ResponseEntity<List<UserResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{user-id}")
  public ResponseEntity<UserResponse> findById(
      @PathVariable("user-id") Integer id
  ) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PatchMapping("/validate/{user-id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Integer validate(
      @PathVariable("user-id") Integer id
  ) {
    return service.validateAccount(id);
  }

  @PatchMapping("/invalidate/{user-id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Integer invalidate(
      @PathVariable("user-id") Integer id
  ) {
    return service.invalidateAccount(id);
  }

}
