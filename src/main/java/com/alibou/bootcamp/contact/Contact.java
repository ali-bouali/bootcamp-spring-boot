package com.alibou.bootcamp.contact;

import com.alibou.bootcamp.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Contact {

  @Id
  @GeneratedValue
  private Integer id;
  private String firstname;
  private String lastname;
  @Column(unique = true)
  private String email;
  private String iban;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
