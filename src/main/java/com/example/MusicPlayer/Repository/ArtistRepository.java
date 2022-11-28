package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
}
