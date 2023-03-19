package com.alibou.bootcamp.account;

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
public class AccountResponse {

  private Integer id;
  private String iban;
  private String userFirstname;
  private String userLastname;

}
