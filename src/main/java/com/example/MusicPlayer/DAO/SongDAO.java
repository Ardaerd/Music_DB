package com.example.MusicPlayer.DAO;

import com.example.MusicPlayer.Model.Song;
import org.springframework.stereotype.Repository;

@Repository
public interface SongDAO {
    public Song findById(Float id);
}
