package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {

    @Query("SELECT S FROM Song S WHERE S.id = ?1")
    Optional<Song> findSongById(Integer id);

    List<Song> findSongByAlbumId(int id);

    List<Song> findSongByArtistId(int id);

    // It is not working probably error is related to the colum name
//    @Query("SELECT S FROM Song S WHERE S.AlbumId = ?1")
//    List<Song> findSongByAlbumId(int id);
}
