package com.alibou.bootcamp.user;

import com.alibou.bootcamp.account.Account;
import com.alibou.bootcamp.contact.Contact;
import com.alibou.bootcamp.role.Role;
import com.alibou.bootcamp.transaction.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
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
@Table(name = "_user")
public class User {

  @Id
  @GeneratedValue
  private Integer id;
  private String firstname;
  private String lastname;
  @Column(unique = true)
  private String email;
  private String password;
  private boolean active;
  @OneToOne
  private Account account;
  @OneToMany(mappedBy = "user")
  private List<Contact> contacts;
  @OneToMany(mappedBy = "user")
  private List<Transaction> transactions;
  @ManyToMany
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private List<Role> roles;
}
