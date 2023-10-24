package com.example.demo.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.demo.entity.DTO.FuzzySearch;
import com.example.demo.entity.DTO.MatchField;
import com.example.demo.entity.Song;
import com.example.demo.service.ElasticSearchService;
import com.example.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @PostMapping("/insert")
    public Song insert(@RequestBody Song song){
        return songService.insertSong(song);
    }

    @GetMapping("/matchAllSongs")
    public List<Song> matchAllSongs() throws IOException {
        SearchResponse<Song> searchResponse =  elasticSearchService.matchAllSongsServices();
        System.out.println(searchResponse.hits().hits().toString());

        List<Hit<Song>> listOfHits= searchResponse.hits().hits();
        List<Song> listOfProducts  = new ArrayList<>();
        for(Hit<Song> hit : listOfHits){
            listOfProducts.add(hit.source());
        }
        return listOfProducts;
    }

    @GetMapping("/matchNameAllSongs")
    public List<Song> matchAllProductsWithName(@RequestBody MatchField matchField) throws IOException {
        SearchResponse<Song> searchResponse =  elasticSearchService.matchSongsWithName(matchField.getFieldValue());
        System.out.println(searchResponse.hits().hits().toString());

        List<Hit<Song>> listOfHits= searchResponse.hits().hits();
        List<Song> listOfProducts  = new ArrayList<>();
        for(Hit<Song> hit : listOfHits){
            listOfProducts.add(hit.source());
        }
        return listOfProducts;
    }

    @GetMapping("/fuzzySongSearch")
    List<Song> fuzzySearch( @RequestBody FuzzySearch fuzzySearch) throws IOException {
        SearchResponse<Song> searchResponse = elasticSearchService.fuzzySongSearch(fuzzySearch.getApproximateProductName());
        List<Hit<Song>> hitList = searchResponse.hits().hits();
        System.out.println(hitList);
        List<Song> productList = new ArrayList<>();
        for(Hit<Song> hit :hitList){
            productList.add(hit.source());
        }
        return productList;
    }

}
