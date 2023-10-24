package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apis")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/findall")
    public Iterable<Product> findall(){
        return productService.getPrduct();
    }

    @PostMapping("/insert")
    public Product insert(@RequestBody Product product){
        return productService.insertPrduct(product);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Product product){
        productService.deletePrduct(product.getId());
    }

}
