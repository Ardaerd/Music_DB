package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

    @Query("SELECT S FROM Song S WHERE S.id = ?1")
    Optional<Song> findSongById(Integer id);


}
