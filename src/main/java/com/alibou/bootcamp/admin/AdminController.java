package com.alibou.bootcamp.admin;

import com.alibou.bootcamp.user.UserResponse;
import com.alibou.bootcamp.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@Tag(name = "Admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {

    private final UserService service;
    @GetMapping("/users/inactive")
    public ResponseEntity<List<UserResponse>> findAllNonActiveUsers() {
        return ResponseEntity.ok(service.findAllUsersByState(false));
    }

    @GetMapping("/users/active")
    public ResponseEntity<List<UserResponse>> findAllActiveUsers() {
        return ResponseEntity.ok(service.findAllUsersByState(true));
    }
}
