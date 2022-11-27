package com.example.MusicPlayer.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name", nullable = false)
    private Long name;

    @Column(name = "Artist", nullable = false)
    private Artist artist;

    @Column(name = "Songs", nullable = false)
    private List<Song> songs;


    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
