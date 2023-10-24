package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepo productRepo;
    public Iterable<Product> getPrduct(){
        return productRepo.findAll();
    }
    public Product insertProduct(Product product){
        return productRepo.save(product);
    }
    public void deletePrduct(int id){
        productRepo.deleteById(id);
    }
    public Product updatePrduct(Product product,int id){
        Product product1 = productRepo.findById(id).get();
        product1.setDescription(product.getDescription());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        return product1;
    }

}
