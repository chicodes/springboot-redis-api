package com.webzifi.intellijtest.controller;

import com.webzifi.intellijtest.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCaching
@RequestMapping("/product")
public class Product {

    @Autowired
    private ProductDao dao;

    @PostMapping
    public com.webzifi.intellijtest.entity.Product save(@RequestBody com.webzifi.intellijtest.entity.Product product){
        return dao.save(product);
    }

    @GetMapping
    public List<com.webzifi.intellijtest.entity.Product> getAllProducts(){
        return dao.findAll();
    }

    @Cacheable(key = "#id", value = "Product", unless = "#result.price > 2000")
    @GetMapping("/{id}")
    public com.webzifi.intellijtest.entity.Product findProduct(@PathVariable int id){
        return dao.findProductById(id);
    }

    @CacheEvict(key = "#id", value = "Product")
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return dao.deleteProduct(id);
    }

}
