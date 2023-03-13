package com.alibou.bootcamp.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class AccountRequest {

  @NotNull(message = "IBAN should not be null") // null
  @NotEmpty(message = "IBAN should not be empty") // ""
  @NotBlank(message = "IBAN should not be blank") // " "
  private String iban;
  @NotNull(message = "User should not be null")
  private Integer userId;

}
