package com.alibou.bootcamp.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

  private Integer id;
  private String firstname;
  private String lastname;
  private String email;
  private String iban;
  private boolean active;

}
