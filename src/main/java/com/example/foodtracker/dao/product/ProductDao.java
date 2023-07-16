package com.example.foodtracker.dao.product;

import com.example.foodtracker.dao.Dao;
import com.example.foodtracker.entity.product.Product;

import java.util.List;

public interface ProductDao extends Dao<Product> {
    List<Product> findProduct(String productName);

    String findProductByBarcode(String barcode);

    String findProductByName(String productName);

}
