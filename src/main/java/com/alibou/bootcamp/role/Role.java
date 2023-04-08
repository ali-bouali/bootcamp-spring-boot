package com.alibou.bootcamp.role;

import com.alibou.bootcamp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Role {

  @Id
  @GeneratedValue
  private Integer id;
  @Column(unique = true)
  private String name;

  @ManyToMany(mappedBy = "roles")
  @JsonIgnore
  private List<User> users;
}
