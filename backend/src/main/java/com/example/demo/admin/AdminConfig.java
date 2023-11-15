package com.example.demo.admin;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    @Bean
    CommandLineRunner AdminCommandLineRunner(AdminRepository repository) {
        return args -> {
            Admin mariam = new Admin(
                    "Mariam",
                    "mariam@bht.de",
                    "pw123",
                    LocalDate.of(2000, Month.JANUARY, 5));
            Admin alex = new Admin(
                    "Alex",
                    "alex@bht.de",
                    "pw123",
                    LocalDate.of(1999, Month.FEBRUARY, 13));
            repository.saveAll(
                    List.of(mariam, alex));
        };
    }

}
