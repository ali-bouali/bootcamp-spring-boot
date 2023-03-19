package com.alibou.bootcamp.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

  boolean existsByUserId(Integer userId);

  boolean existsByIban(String iban);

}
