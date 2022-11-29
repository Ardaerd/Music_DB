package com.example.MusicPlayer.Service;

import com.example.MusicPlayer.Model.Album;
import com.example.MusicPlayer.Model.Song;
import com.example.MusicPlayer.Services.MusicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestMusicService {
    @Autowired
    MusicService musicService;

    @Test
    @Commit
    public void testSaveAlbum() {
        Album afterHouse = new Album("After Hours");

        List<Song> songs = new ArrayList<>();
        Song song_1 = new Song("Alone Again",4,afterHouse);
        Song song_2 = new Song("Too Late",4,afterHouse);
        Song song_3 = new Song("Hardest To Love",3,afterHouse);
        Song song_4 = new Song("After Hours",6,afterHouse);

        songs.add(song_1);
        songs.add(song_2);
        songs.add(song_3);
        songs.add(song_4);


        afterHouse.setSongs(songs);
        musicService.saveAlbum(afterHouse);
        
       Album album = musicService.getAlbumRepository().findAlbumById(1).get();

       songs = musicService.getSongRepository().findSongByAlbumId(album.getId());

        System.out.println("Album Name: " + album.getName());
        for (Song song: songs) {
            System.out.println("Song name: " + song.getName() + " Album Id: " + song.getAlbum().getId());
        }
    }
    @Test
    public void testAddSongToAlbum() {
        testSaveAlbum();

        Song newSong = new Song("Call Out My Name",4);

        musicService.addSongToAlbum(1,newSong);
    }

    @Test
    public void testAssignArtistToAlbum() {
        testSaveAlbum();

        musicService.addArtist("The Blaze");
        Album album = musicService.getAlbumRepository().findAlbumById(1).get();
        List<Song> songs = musicService.getSongRepository().findSongByAlbumId(album.getId());

        album.setSongs(songs);
        album.setArtist(musicService.getArtistRepository().findArtistById(1).get());

        musicService.addArtist("The Weekend");
        album.setArtist(musicService.getArtistRepository().findArtistById(2).get());

        musicService.assignArtistToAlbum(1,2);
    }
}
