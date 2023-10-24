package com.example.demo.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.demo.entity.DTO.FuzzySearch;
import com.example.demo.entity.DTO.MatchField;
import com.example.demo.entity.Product;
import com.example.demo.service.ElasticSearchService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apis")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ElasticSearchService elasticSearchService;
    @GetMapping("/findall")
    public Iterable<Product> findall(){
        return productService.getPrduct();
    }

    @PostMapping("/insert")
    public Product insert(@RequestBody Product product){
        return productService.insertProduct(product);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Product product){
        productService.deletePrduct(product.getId());
    }

    @GetMapping("/matchAll")
    public String matchAll() throws IOException {
        SearchResponse<Map> searchResponse =  elasticSearchService.matchAllServices();
        System.out.println(searchResponse.hits().hits().toString());
        return searchResponse.hits().hits().toString();
    }

    @GetMapping("/matchAllProducts")
    public List<Product> matchAllProducts() throws IOException {
        SearchResponse<Product> searchResponse =  elasticSearchService.matchAllProductsServices();
        System.out.println(searchResponse.hits().hits().toString());

        List<Hit<Product>> listOfHits= searchResponse.hits().hits();
        List<Product> listOfProducts  = new ArrayList<>();
        for(Hit<Product> hit : listOfHits){
            listOfProducts.add(hit.source());
        }
        return listOfProducts;
    }

    @GetMapping("/matchNameAllProducts")
    public List<Product> matchAllProductsWithName(@RequestBody MatchField matchField) throws IOException {
        SearchResponse<Product> searchResponse =  elasticSearchService.matchProductsWithName(matchField.getFieldValue());
        System.out.println(searchResponse.hits().hits().toString());

        List<Hit<Product>> listOfHits= searchResponse.hits().hits();
        List<Product> listOfProducts  = new ArrayList<>();
        for(Hit<Product> hit : listOfHits){
            listOfProducts.add(hit.source());
        }
        return listOfProducts;
    }

    @GetMapping("/fuzzySearch")
    List<Product> fuzzySearch( @RequestBody FuzzySearch fuzzySearch) throws IOException {
        SearchResponse<Product> searchResponse = elasticSearchService.fuzzySearch(fuzzySearch.getApproximateProductName());
        List<Hit<Product>> hitList = searchResponse.hits().hits();
        System.out.println(hitList);
        List<Product> productList = new ArrayList<>();
        for(Hit<Product> hit :hitList){
            productList.add(hit.source());
        }
        return productList;
    }


}
