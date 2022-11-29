package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist,Integer> {
    @Query("SELECT A FROM Artist A WHERE A.id = ?1")
    Optional<Artist> findArtistById(Integer id);
}
