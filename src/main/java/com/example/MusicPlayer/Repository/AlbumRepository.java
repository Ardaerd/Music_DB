package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Float> {

}
