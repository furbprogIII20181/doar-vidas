package com.furb.br.doarvidas;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.furb.br.doarvidas.model.RoleEntity;
import com.furb.br.doarvidas.model.UserEntity;
import com.furb.br.doarvidas.services.UserService;

@SpringBootApplication
public class DoarVidasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoarVidasApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            service.save(new UserEntity("user", "user", Arrays.asList(new RoleEntity("USER"))));
        };
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    } 
	
}
