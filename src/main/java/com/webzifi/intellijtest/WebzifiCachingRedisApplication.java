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
public class WebzifiCachingRedisApplication {
	public static void main(String[] args) {

		SpringApplication.run(WebzifiCachingRedisApplication.class, args);
	}
}
