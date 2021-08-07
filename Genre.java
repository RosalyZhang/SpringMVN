package com.example.springmvn.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "song_id")
    @JsonBackReference
    private Song songList;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
