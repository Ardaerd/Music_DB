package com.example.MusicPlayer.Services;

import com.example.MusicPlayer.Model.Album;
import com.example.MusicPlayer.Model.Artist;
import com.example.MusicPlayer.Model.Playlist;
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
        Artist artist = albumRepository.findAlbumById(albumId).get().getArtist();

        song.setAlbum(album);
        song.setArtist(artist);

        List<Song> songs = album.getSongs();
        songs.add(song);
        album.setSongs(songs);

        albumRepository.save(album);
    }

    @Transactional
    public void assignArtistToAlbum(int albumId, int artistId) {
        Album album = albumRepository.findAlbumById(albumId).get();
        Artist artist = artistRepository.findArtistById(artistId).get();
        List<Song> songs = songRepository.findSongByAlbumId(albumId);

        for (Song song : songs)
            song.setArtist(artist);


        album.setArtist(artist);

        songRepository.saveAll(songs);
        albumRepository.save(album);
    }

    @Transactional
    public void deleteAlbum(int albumId) {
        List<Song> songs = songRepository.findSongByAlbumId(albumId);

        for (Song song : songs) {
            song.setAlbum(null);
        }

        songRepository.saveAll(songs);
        albumRepository.deleteById(albumId);
    }


    public void deleteSong(int songId) {
        Song song = songRepository.findSongById(songId).get();
        songRepository.deleteById(songId);
    }

    @Transactional
    public void addSongToPlaylist(int playlistId, int songId) {
        Song song = songRepository.findSongById(songId).get();
        Playlist playlist = playlistRepository.findPlaylistById(playlistId).get();

        List<Song> songs = playlist.getSongs();
        songs.add(song);

        playlist.setSongs(songs);

        playlistRepository.save(playlist);

    }

    @Transactional
    public void addPlaylistToPlaylist(int parentPlaylistId, int childPlaylistId) {
        Playlist childPlaylist = playlistRepository.findPlaylistById(childPlaylistId).get();
        System.out.println(childPlaylist.getId());
        Playlist parentPlaylist = playlistRepository.findPlaylistById(parentPlaylistId).get();
        System.out.println(parentPlaylist.getId());
        List<Song> childSongs = childPlaylist.getSongs();
        List<Song> parentSongs = parentPlaylist.getSongs();

        List<Playlist> listOfPlaylist = parentPlaylist.getPlaylists();
        parentPlaylist.getPlaylists().add(childPlaylist);

        //parentSongs.addAll(childSongs);

        //parentPlaylist.setSongs(parentSongs);
        //parentPlaylist.setPlaylists(listOfPlaylist);
        playlistRepository.save(parentPlaylist);

    }

    public List<Song> findSongWithArtistId(int id) {

        return songRepository.findSongByArtistId(id);
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
