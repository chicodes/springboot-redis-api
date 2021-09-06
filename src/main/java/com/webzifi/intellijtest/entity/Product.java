package com.webzifi.intellijtest.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table
@RedisHash("product")
public class Product implements Serializable {

    @Id
    private int id;
    private String name;
    private int qty;
    private long price;

    public Product() {
    }

    public Product(int id, String name, int qty, long price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
