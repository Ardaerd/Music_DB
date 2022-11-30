package com.example.MusicPlayer.Service;

import com.example.MusicPlayer.Model.Album;
import com.example.MusicPlayer.Model.Artist;
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

        musicService.addArtist("The Blaze");
        Artist artist = musicService.getArtistRepository().findArtistById(1).get();


        List<Song> songs = new ArrayList<>();
        Song song_1 = new Song("Alone Again",artist, 4,afterHouse);
        Song song_2 = new Song("Too Late",artist,4,afterHouse);
        Song song_3 = new Song("Hardest To Love",artist,3,afterHouse);
        Song song_4 = new Song("After Hours",artist,6,afterHouse);

        songs.add(song_1);
        songs.add(song_2);
        songs.add(song_3);
        songs.add(song_4);


        afterHouse.setSongs(songs);
        afterHouse.setArtist(artist);
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
        testAddSongToAlbum();

        Album album = musicService.getAlbumRepository().findAlbumById(1).get();
        List<Song> songs = musicService.getSongRepository().findSongByAlbumId(album.getId());

        album.setSongs(songs);
        album.setArtist(musicService.getArtistRepository().findArtistById(1).get());
        musicService.getAlbumRepository().save(album);

        musicService.addArtist("The Weekend");


        musicService.assignArtistToAlbum(1,2);
    }

    @Test
    public void testDeleteAlbum() {
        testSaveAlbum();

        Album album = musicService.getAlbumRepository().findAlbumById(1).get();

        musicService.deleteAlbum(album.getId());
    }


    @Test
    public void testDeleteSong() {
        testSaveAlbum();

        Song song = musicService.getSongRepository().findSongById(4).get();
        System.out.println(song.getName());

        musicService.deleteSong(song.getId());

    }

    @Test
    public void testFindSongWithArtistId() {
        testSaveAlbum();

        List<Song> songs = musicService.findSongWithArtistId(1);

        for (Song song : songs) {
            System.out.println("Song Name: " + song.getName() + ", " + "Artist ID: " + song.getArtist().getId());
        }
    }

}
