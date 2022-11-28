package com.example.MusicPlayer.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany
    @JoinTable(name = "Artist_Songs",
    joinColumns = @JoinColumn(name = "Artist_ID",
    referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "Song_ID",
    referencedColumnName = "id"))
    private List<Song> songs = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "Artist_Albums",
            joinColumns = @JoinColumn(name = "Artist_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Album_ID", referencedColumnName = "id"))
    private List<Album> albums = new ArrayList<>();

    public Artist(String name) {
        this.name = name;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
