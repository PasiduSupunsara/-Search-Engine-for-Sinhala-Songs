package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.Song;
import com.example.demo.repo.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Autowired
    private SongRepo songRepo;
    public Song insertSong(Song song){
        return songRepo.save(song);
    }
}
