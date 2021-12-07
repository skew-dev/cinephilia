package com.skewdev.cinephilia;

import com.skewdev.cinephilia.entity.Role;
import com.skewdev.cinephilia.entity.User;
import com.skewdev.cinephilia.service.UsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class CinephiliaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinephiliaApplication.class, args);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UsersService service) {
        return args -> {

            //moviesService.save(new Movie(null, "Hobbit"));

            service.saveRole(new Role(null, "ROLE_USER"));
            service.saveRole(new Role(null, "ROLE_MODERATOR"));

            service.saveUser(new User("Teo Dawn","", "123456789", new ArrayList<>()));

            service.addRoleToUser("Teo Dawn", "ROLE_MODERATOR");
        };
    }

}
