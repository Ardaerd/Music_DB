package com.example.MusicPlayer.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name", nullable = false)
    private Long name;

    @Column(name = "Playlists", nullable = false)
    private List<Playlist> playlists;

    @Column(name = "Songs", nullable = false)
    private List<Song> songs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
