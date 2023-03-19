package com.alibou.bootcamp.transaction;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
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
public class TransactionRequest {

  @NotNull(message = "Amount is mandatory")
  @Positive(message = "Amount should be positive")
  @Min(1)
  private BigDecimal amount;
  @NotNull(message = "IBAN is mandatory")
  private String destinationIban;
  @NotNull(message = "TYpe is mandatory")
  private TransactionType type;
  @NotNull(message = "User is mandatory")
  private Integer userId;

}
