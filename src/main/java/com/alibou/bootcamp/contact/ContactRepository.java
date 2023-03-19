package com.alibou.bootcamp.contact;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

  List<Contact> findAllByUserId(Integer id);
}
