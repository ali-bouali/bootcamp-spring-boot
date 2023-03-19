package com.alibou.bootcamp.contact;

import com.alibou.bootcamp.account.AccountResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

  private final ContactService service;

  @PostMapping
  public Integer save(
      @RequestBody ContactRequest contact
  ) {
    return service.create(contact);
  }

  @GetMapping("/user/{user-id}")
  public ResponseEntity<List<ContactResponse>> findAll(
      @PathVariable("user-id") Integer id
  ) {
    return ResponseEntity.ok(service.findAllByUser(id));
  }

  @GetMapping("/{contact-id}")
  public ResponseEntity<ContactResponse> findById(
      @PathVariable("contact-id") Integer id
  ) {
    return ResponseEntity.ok(service.findById(id));
  }

  @DeleteMapping("/{account-id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(
      @PathVariable("account-id") Integer id
  ) {
    service.delete(id);
  }
}
