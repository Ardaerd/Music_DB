package com.example.MusicPlayer.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name", nullable = false)
    private Long name;

    @ManyToOne
    @JoinColumn(name = "Artist_ID")
    private Artist artist;

    @OneToMany
    @JoinColumn(name = "Songs_ID")
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
