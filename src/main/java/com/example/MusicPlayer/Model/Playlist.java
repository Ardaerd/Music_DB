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

    @ManyToMany
    @JoinTable(name = "Playlist_Playlists",
            joinColumns = @JoinColumn(name = "Playlist_1_ID",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Playlist_2_ID",
                    referencedColumnName = "id"))
    private List<Playlist> playlists;

    @ManyToMany
    @JoinTable(name = "Playlist_Songs",
            joinColumns = @JoinColumn(name = "Playlist_ID",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Song_ID",
                    referencedColumnName = "id"))
    private List<Song> songs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
