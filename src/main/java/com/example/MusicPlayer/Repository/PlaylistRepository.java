package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
}
