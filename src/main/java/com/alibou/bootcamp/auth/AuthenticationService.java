package com.alibou.bootcamp.auth;

import com.alibou.bootcamp.role.Role;
import com.alibou.bootcamp.role.RoleRepository;
import com.alibou.bootcamp.role.RoleType;
import com.alibou.bootcamp.security.JwtService;
import com.alibou.bootcamp.user.User;
import com.alibou.bootcamp.user.UserRepository;
import com.alibou.bootcamp.validator.ObjectsValidator;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository useruserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final ObjectsValidator<RegisterRequest> validator;

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        validator.validate(request);
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(request.getPassword())
                )
                .build();
        // set roles
        var userRole = roleRepository.findByName(RoleType.ROLE_USER.name())
                .orElse(
                        Role.builder()
                                .name(RoleType.ROLE_USER.name())
                                .build()
                );
        if (userRole.getId() == null) {
            userRole = roleRepository.save(userRole);
        }
        var defaultUserRole = List.of(userRole);
        user.setRoles(defaultUserRole);
        var savedUser = useruserRepository.save(user);

        userRole.setUsers(new ArrayList<>(List.of(savedUser)));
        roleRepository.save(userRole);
        var claims = new HashMap<String, Object>();
        claims.put("role", user.getRoles());
        claims.put("active", user.isActive());
        var jwtToken = jwtService.generateToken(savedUser, claims);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getFirstname() + " " + user.getLastname())
                .userId(savedUser.getId())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = useruserRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var claims = new HashMap<String, Object>();
        claims.put("role", user.getRoles());
        claims.put("active", user.isActive());
        var jwtToken = jwtService.generateToken(user, claims);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getFirstname() + " " + user.getLastname())
                .userId(user.getId())
                .build();
    }
}
