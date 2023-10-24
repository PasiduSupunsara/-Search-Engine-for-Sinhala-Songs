package com.example.demo.repo;

import com.example.demo.entity.Song;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SongRepo extends ElasticsearchRepository<Song,Integer> {
}
