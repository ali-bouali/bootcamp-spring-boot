package com.alibou.bootcamp.transaction;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

  List<Transaction> findAllByUserId(Integer userId);

  @Query("""
      select sum(t.amount)
      from Transaction t
      where t.user.id = :id
      """)
  BigDecimal findAccountBalance(@Param("id") Integer userId);

  @Query("""
      select max(abs(t.amount))
      FROM Transaction t
      WHERE t.user.id = :userId
      AND t.type = :transactionType
      """)
  BigDecimal findHighestAmountByTransactionType(@Param("userId") Integer userId, @Param("transactionType") TransactionType transactionType);
}
