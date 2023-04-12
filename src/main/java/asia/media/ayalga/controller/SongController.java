/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asia.media.ayalga.controller;

import asia.media.ayalga.entity.Song;
import asia.media.ayalga.repository.SongRepository;
import java.io.IOException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kbuty
 */
@RestController
@RequestMapping("song")
public class SongController {
    
    @Autowired
    SongRepository repo;
    
    @GetMapping("all")
    public ResponseEntity<List<String>> getAllSongNames(){
        return ResponseEntity.ok(repo.getAllEntryNames());
    }
    
    @PostMapping
    public ResponseEntity<String> saveSong(@RequestParam("file") MultipartFile file) throws IOException{
        Song s = new Song(file.getOriginalFilename(), file.getBytes());
        repo.save(s);
        return ResponseEntity.ok("Ыры шыгжатынган");
    }
    
    @GetMapping("{name}")
    public ResponseEntity<Resource> getSongByName(@PathVariable("name") String name){
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(repo.findById(name).get().getData()));
    }
}
