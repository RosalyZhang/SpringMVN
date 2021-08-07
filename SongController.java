package com.example.springmvn.Controller;

import com.example.springmvn.Model.Song;
import com.example.springmvn.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/song")
public class SongController {
    @Autowired
    SongRepository songRepository;

    @GetMapping("/")
    public List<Song> findAll(){
        return songRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()){
            return ResponseEntity.ok(song.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public Song findByIdInQuery(@RequestParam Long id){
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()){
            return song.get();
        } else {
            return new Song ("Fehlermeldung");
        }
    }

    @GetMapping("/name")
    public ResponseEntity<?> findbyName(@RequestParam String name){
        return ResponseEntity.ok(songRepository.findAllByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveSong (@RequestBody @Valid Song song){
        return new ResponseEntity<>(songRepository.save(song), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSong (@PathVariable Long id){
        songRepository.deleteById(id);
        return new ResponseEntity<>("Der Song mit der ID" + id + " wurde gelöscht", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSongByQuery (@RequestParam Long id){
        songRepository.deleteById(id);
        return new ResponseEntity<>("Der Song mit der ID" + id + " wurde gelöscht", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSong (@RequestParam Long id, @RequestBody String name){
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()){
            Song updateSong = song.get();
            updateSong.setName(name);
            return new ResponseEntity<>(songRepository.save(updateSong), HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
