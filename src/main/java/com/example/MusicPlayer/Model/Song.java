package com.example.MusicPlayer.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "Artist_ID")
    private Artist artist;

    @Column(name = "Length", nullable = false)
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "Album_Id")
    private Album album;


    public Song() {
    }

    public Song(String name, Artist artist, Integer length, Album album) {
        this.name = name;
        this.artist = artist;
        this.length = length;
        this.album = album;
    }

    public Song(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    public Song(String name, Integer length, Album album) {
        this.name = name;
        this.length = length;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", length=" + length +
                '}';
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
