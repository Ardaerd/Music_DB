package com.example.MusicPlayer.Service;

import com.example.MusicPlayer.Model.Album;
import com.example.MusicPlayer.Model.Song;
import com.example.MusicPlayer.Services.MusicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestMusicService {
    @Autowired
    MusicService musicService;

    @Test
    public void testSaveAlbum() {
        List<Song> songs = new ArrayList<>();
        Song song_1 = new Song("Alone Again",4);
        Song song_2 = new Song("Too Late",4);
        Song song_3 = new Song("Hardest To Love",3);
        Song song_4 = new Song("After Hours",6);

        songs.add(song_1);
        songs.add(song_2);
        songs.add(song_3);
        songs.add(song_4);

        Album afterHouse = new Album("After House");
        afterHouse.setSongs(songs);
        musicService.saveAlbum(afterHouse);
        
        Album al = musicService.getAlbumRepository().findAlbumById(1).get();

        System.out.println(al.getName());
        //musicService.addSongToAlbum(afterHouse.getId(),new Song("Blinding Lights",3));
    }
}
