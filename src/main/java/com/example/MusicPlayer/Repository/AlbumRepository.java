package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album,Float> {

    @Query("SELECT A FROM Album A WHERE A.id = ?1")
    Optional<Album> findAlbumById(Integer id);
}
