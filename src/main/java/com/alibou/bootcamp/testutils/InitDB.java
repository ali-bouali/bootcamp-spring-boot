package com.alibou.bootcamp.testutils;

import com.alibou.bootcamp.role.Role;
import com.alibou.bootcamp.role.RoleRepository;
import com.alibou.bootcamp.user.User;
import com.alibou.bootcamp.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("qa")
@RequiredArgsConstructor
@Slf4j
public class InitDB {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @PostConstruct
    public void insertAdminUser() {
        log.info("Insert ADMIN user for QA purposes");
        var role = roleRepository.save(
                Role.builder()
                        .name("ROLE_ADMIN")
                .build()
        );
        userRepository.save(
                User.builder()
                        .firstname("ali")
                        .lastname("bouali")
                        .email("admin@alibou.com")
                        .password("$2a$10$3ek/PrpenD0.ppuO7Jp7HulcpTqpcUrETeKbIVwUrU139n5Co3nZO")
                        .roles(List.of(role))
                        .active(true)
                        .build()
        );
    }
}
