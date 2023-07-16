package com.example.foodtracker.service;

import com.example.foodtracker.dao.product.HibernateNewProductDao;
import com.example.foodtracker.dao.product.ProductDao;
import com.example.foodtracker.entity.product.NewProduct;
import com.example.foodtracker.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private HibernateNewProductDao hibernateNewProductDao;

    public void createProduct(Product product) {
        productDao.save(product);
    }

    public Product findProductByName(String nameProduct) {
        return productDao.findProduct(nameProduct);
    }

    public String findProductByBarcode(String barcode) {
        return productDao.findProductByBarcode(barcode);

    }

    public String findProductByProductName(String productName) {
        return productDao.findProductByName(productName);
    }


    public void createNewProduct(NewProduct newProduct) {
        hibernateNewProductDao.save(newProduct);
    }
}
