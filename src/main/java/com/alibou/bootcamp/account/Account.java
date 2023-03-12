package com.alibou.bootcamp.account;

import com.alibou.bootcamp.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Account {

  @Id
  @GeneratedValue
  private Integer id;
  @Column(unique = true)
  private String iban;
  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

}
