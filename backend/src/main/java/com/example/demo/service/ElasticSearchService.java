package com.example.demo.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.demo.entity.Song;
import com.example.demo.util.ElasticSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;
@Service
public class ElasticSearchService {

    @Autowired
    private ElasticsearchClient  elasticsearchClient;

    public SearchResponse<Map> matchAllServices() throws IOException {
        Supplier<Query> supplier  = ElasticSearchUtil.supplier();
        SearchResponse<Map> searchResponse = elasticsearchClient.search(s->s.query(supplier.get()),Map.class);
        System.out.println("elasticsearch query is "+supplier.get().toString());
        return searchResponse;
    }



    public SearchResponse<Song> matchAllSongsServices() throws IOException {
        Supplier<Query> supplier  = ElasticSearchUtil.supplier();
        SearchResponse<Song> searchResponse = elasticsearchClient.search(s->s.index("songs").query(supplier.get()),Song.class);
        System.out.println("elasticsearch query is "+supplier.get().toString());
        return searchResponse;
    }



    public SearchResponse<Song> matchSongsWithName(String fieldValue,String field) throws IOException{
        Supplier<Query> supplier  = ElasticSearchUtil.supplierWithField(fieldValue,field);
        SearchResponse<Song> searchResponse = elasticsearchClient.search(s->s.index("songs").query(supplier.get()),Song.class);
        System.out.println("elasticsearch query is "+supplier.get().toString());
        return searchResponse;
    }



    public SearchResponse<Song> fuzzySongSearch(String approximateProductName) throws IOException {
        Supplier<Query>  supplier = ElasticSearchUtil.createSupplierQuery(approximateProductName);
        SearchResponse<Song> response = elasticsearchClient
                .search(s->s.index("songs").query(supplier.get()),Song.class);
        System.out.println("elasticsearch supplier fuzzy query "+supplier.get().toString());
        return response;
    }


    public SearchResponse<Song> autoSuggestSong(String partialProductName) throws IOException {

        Supplier<Query> supplier = ElasticSearchUtil.createSupplierAutoSuggest(partialProductName);
        SearchResponse<Song> searchResponse  = elasticsearchClient
                .search(s->s.index("songs").query(supplier.get()), Song.class);
        System.out.println(" elasticsearch auto suggestion query"+supplier.get().toString());
        return searchResponse;
    }
}
