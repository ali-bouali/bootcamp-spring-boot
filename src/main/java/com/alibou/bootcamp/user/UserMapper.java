package com.alibou.bootcamp.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toUser(UserRequest request) {
    return User.builder()
        .id(request.getId())
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(request.getPassword())
        .build();
  }

  public UserResponse toResponse(User user) {
    return UserResponse.builder()
        .id(user.getId())
        .firstname(user.getFirstname())
        .lastname(user.getLastname())
        .email(user.getEmail())
        .active(user.isActive())
        .iban(user.getAccount().getIban())
        .build();
  }
}
