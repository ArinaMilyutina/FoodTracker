package com.example.foodtracker.dao.product;


import com.example.foodtracker.entity.product.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;


@Service
public class HibernateProductDao implements ProductDao {
    private static final String FIND_PRODUCT_BY_NAME = "from Product where productName like :productName";
    private static final String PRODUCT_NAME = "productName";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findProductByName(String productName) {
        return entityManager.createQuery(FIND_PRODUCT_BY_NAME, Product.class)
                .setParameter(PRODUCT_NAME, productName)
                .getSingleResult();
    }
}
