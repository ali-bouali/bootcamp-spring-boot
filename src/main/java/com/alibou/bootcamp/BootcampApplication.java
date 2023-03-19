package com.alibou.bootcamp;

import com.alibou.bootcamp.account.AccountRequest;
import com.alibou.bootcamp.account.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootcampApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AccountService service
	) {
		return args -> {
			// service.save(AccountRequest.builder().build());
		};
	}
}
