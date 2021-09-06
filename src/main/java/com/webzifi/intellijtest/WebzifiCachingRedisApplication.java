package com.webzifi.intellijtest;

import com.webzifi.intellijtest.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.webzifi.intellijtest.repository.ProductDao;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
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

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id){
		return dao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id){
		return dao.deleteProduct(id);
	}
	public static void main(String[] args) {
		SpringApplication.run(WebzifiCachingRedisApplication.class, args);
	}

}
