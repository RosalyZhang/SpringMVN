package com.example.springmvn.Repository;

import com.example.springmvn.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    public List<Song> findAllByName(String name);
}
