package com.skewdev.cinephilia;

import com.skewdev.cinephilia.entity.Movie;
import com.skewdev.cinephilia.entity.Role;
import com.skewdev.cinephilia.entity.User;
import com.skewdev.cinephilia.service.MovieService;
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

    /*@Bean
    CommandLineRunner run(UsersService service, MovieService movieService) {
        return args -> {

            //moviesService.save(new Movie(null, "Hobbit"));
            Movie movie = new Movie("Dune", "2021", "Good movie","https://www.themoviedb.org/t/p/w220_and_h330_face/d5NXSklXo0qyIYkgV94XAgMIckC.jpg");
            movieService.addNewMovie(movie);

            service.saveRole(new Role(null, "ROLE_USER"));
            service.saveRole(new Role(null, "ROLE_MODERATOR"));

            service.saveUser(new User("teo","", "123456789", new ArrayList<>()));

            service.addRoleToUser("teo", "ROLE_MODERATOR");
        };
    }*/

}
