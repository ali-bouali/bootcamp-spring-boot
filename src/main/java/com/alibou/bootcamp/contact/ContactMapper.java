package com.alibou.bootcamp.contact;

import com.alibou.bootcamp.user.User;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

  public Contact toContact(ContactRequest request) {
    return Contact.builder()
        .id(request.getId())
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .iban(request.getIban())
        .user(
            User.builder()
                .id(request.getUserId())
                .build()
        )
        .build();
  }

  public ContactResponse toResponse(Contact contact) {
    return ContactResponse.builder()
        .id(contact.getId())
        .firstname(contact.getFirstname())
        .lastname(contact.getLastname())
        .email(contact.getEmail())
        .iban(contact.getIban())
        .build();
  }
}
