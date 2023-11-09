package com.example.demo.song;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SongConfig {
    
    @Bean
    CommandLineRunner SongCommandLineRunner(SongRepository repository){
        return args -> {
            Song song1 = new Song(
                "Joe",
                "Mama",
                200,
                0,
                "Test"
            );
            repository.saveAll(
                List.of(song1));
        };
    }
}
