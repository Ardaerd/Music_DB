package com.example.MusicPlayer.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Artist {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "Songs", nullable = false)
    private List<Song> songs;

    @Column(name = "Albums", nullable = false)
    private List<Album> albums;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
