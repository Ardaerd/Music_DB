package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {

}
