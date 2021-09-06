package com.webzifi.intellijtest;

import com.webzifi.intellijtest.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;
import com.webzifi.intellijtest.repository.ProductDao;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
@EnableCaching
public class WebzifiCachingRedisApplication {

	@Autowired
	private ProductDao dao;

	@PostMapping
	public Product save(@RequestBody Product product){
		return dao.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts(){
		return dao.findAll();
	}

	@Cacheable(key = "#id", value = "Product", unless = "#result.price > 2000")
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id){
		return dao.findProductById(id);
	}

	@CacheEvict(key = "#id", value = "Product")
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id){
		return dao.deleteProduct(id);
	}
	public static void main(String[] args) {
		SpringApplication.run(WebzifiCachingRedisApplication.class, args);
	}

}
