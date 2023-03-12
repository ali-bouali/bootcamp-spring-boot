package com.alibou.bootcamp.transaction;

import com.alibou.bootcamp.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Entity
public class Transaction {

  @Id
  @GeneratedValue
  private Integer id;
  private BigDecimal amount;
  private String destinationIban;
  private LocalDate transactionDate;
  @Enumerated(EnumType.STRING)
  private TransactionType type;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
