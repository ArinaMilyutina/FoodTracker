package com.example.foodtracker.dao.product;

import com.example.foodtracker.dao.Dao;
import com.example.foodtracker.entity.product.Product;

public interface ProductDao extends Dao<Product> {
    Product findProductByName(String productName);
}
