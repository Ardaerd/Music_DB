package com.example.MusicPlayer.Services;

import com.example.MusicPlayer.Repository.AlbumRepository;
import com.example.MusicPlayer.Repository.ArtistRepository;
import com.example.MusicPlayer.Repository.PlaylistRepository;
import com.example.MusicPlayer.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
