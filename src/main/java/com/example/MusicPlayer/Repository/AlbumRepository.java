package com.example.MusicPlayer.Repository;

import com.example.MusicPlayer.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query("SELECT A FROM Album A WHERE A.id = ?1")
    Optional<Album> findAlbumById(Integer id);

//    @Modifying
//    @Query("UPDATE Album A SET A.Artist_Id = :name WHERE A.id = :id")
//    void updateAddress(@Param("id") int albumId, @Param("artistId") int artistId);
}
