package com.example.springmvn.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Song {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "The name of a song may not be null")
    private String name;

    @Min(value = 0)
    @Max(value = 30)
    private float time;

    @OneToMany(cascade = CascadeType.ALL)
    @Size(min = 1)
    @JoinColumn(name = "song_id")
    @JsonManagedReference
    private List<Genre> genreList = new ArrayList<>();

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public Song(String name, float time, List<Genre> genreList) {
        this.name = name;
        this.time = time;
        this.genreList = genreList;
    }

    public Song() {
    }

//    public Song(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public Song(String name) {
        this.name = name;
    }

    public Song(String name, float time) {
        this.name = name;
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
