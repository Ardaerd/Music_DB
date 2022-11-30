package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {

    //@Query("SELECT P FROM Playlist P WHERE P.id = ?1")
    Optional<Playlist> findPlaylistById(Integer id);

}
