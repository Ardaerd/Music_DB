package com.example.MusicPlayer.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "Playlist_Playlists",
            joinColumns = @JoinColumn(name = "Parent_Playlist",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Child_Playlist",
                    referencedColumnName = "id"))
    private List<Playlist> playlists = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "Playlist_Songs",
            joinColumns = @JoinColumn(name = "Playlist_ID",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Song_ID",
                    referencedColumnName = "id"))
    private List<Song> songs = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public Playlist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
