package com.example.MusicPlayer.Services;

import com.example.MusicPlayer.Model.Album;
import com.example.MusicPlayer.Model.Artist;
import com.example.MusicPlayer.Model.Song;
import com.example.MusicPlayer.Repository.AlbumRepository;
import com.example.MusicPlayer.Repository.ArtistRepository;
import com.example.MusicPlayer.Repository.PlaylistRepository;
import com.example.MusicPlayer.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicService {
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;
    private final PlaylistRepository playlistRepository;

    @Autowired
    public MusicService(AlbumRepository albumRepository, ArtistRepository artistRepository, SongRepository songRepository, PlaylistRepository playlistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
    }

    @Transactional
    public void saveAlbum(Album album) {
        List<Song> songs = album.getSongs();

        albumRepository.save(album);
        songRepository.saveAll(songs);

    }

    @Transactional
    public void addSongToAlbum(int albumId, Song song) {
        Album album = albumRepository.findAlbumById(albumId).get();
        song.setAlbum(album);

        albumRepository.save(album);

        List<Song> songs = album.getSongs();
        songs.add(song);
        album.setSongs(songs);

    }

    @Transactional
    public void assignArtistToAlbum(int albumId, int artistId) {
        Album album = albumRepository.findAlbumById(albumId).get();
        Artist artist = artistRepository.findArtistById(artistId).get();

        album.setArtist(artist);

        albumRepository.save(album);
    }

    public List<Song> getSongs() {

        return songRepository.findAll();
    }

    @Transactional
    public void addArtist(String artistName) {
        Artist artist = new Artist(artistName);
        artistRepository.save(artist);
    }

    public AlbumRepository getAlbumRepository() {
        return albumRepository;
    }

    public ArtistRepository getArtistRepository() {
        return artistRepository;
    }

    public SongRepository getSongRepository() {
        return songRepository;
    }

    public PlaylistRepository getPlaylistRepository() {
        return playlistRepository;
    }
}
