package com.example.springmvn;

import com.example.springmvn.Model.Genre;
import com.example.springmvn.Model.Song;
import com.example.springmvn.Repository.GenreRepository;
import com.example.springmvn.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringMvnApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvnApplication.class, args);
    }

    @Autowired
    private SongRepository songrepository;
    private GenreRepository genreRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Genre> genreList = new ArrayList(List.of(new Genre("J-rock")));
        List<Genre> genreList1 = new ArrayList<>(List.of(new Genre("J-pop")));


        songrepository.save(new Song("My heart draws a dream",5.0f, genreList));
        songrepository.save(new Song("Daybreaks Bell", 4.0f, genreList1));
//       songrepository.save(new Song("The beginning", 5.0f));

    }
}

