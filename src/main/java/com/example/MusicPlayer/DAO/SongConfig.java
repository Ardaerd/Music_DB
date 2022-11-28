package com.example.MusicPlayer.DAO;

import com.example.MusicPlayer.Model.Song;
import com.example.MusicPlayer.Repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SongConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            SongRepository repository
    ) {
        return args -> {
            Song blinded_by_lights = new Song(
                    "Blinded by lights",
                    2
            );

            Song i_was_never_there = new Song(
                    "I was never there",
                    3
            );

            repository.saveAll(List.of(blinded_by_lights,i_was_never_there));
        };
    }

}
