package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner UserCommandLineRunner(UserRepository repository) {
        return args -> {
            User mariam = new User(
                    "Mariam",
                    "mariam@bht.de",
                    LocalDate.of(2000, Month.JANUARY, 5));
            User alex = new User(
                    "Alex",
                    "alex@bht.de",
                    LocalDate.of(1999, Month.FEBRUARY, 13));
            repository.saveAll(
                    List.of(mariam, alex));
        };
    }

}
