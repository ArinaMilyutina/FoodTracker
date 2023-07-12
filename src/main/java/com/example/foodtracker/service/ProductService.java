package com.example.foodtracker.service;

import com.example.foodtracker.dao.product.ProductDao;
import com.example.foodtracker.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public void createProduct(Product product) {
        productDao.save(product);
    }

    public Product findProductByName(String nameProduct) {
        return productDao.findProductByName(nameProduct);
    }

    public String findProductByBarcode(String barcode) {
        return productDao.findProductByBarcode(barcode);

    }
}
