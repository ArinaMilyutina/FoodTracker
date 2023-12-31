package com.example.foodtracker.dao.product;


import com.example.foodtracker.entity.product.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class HibernateProductDao implements ProductDao {
    private static final String FIND_PRODUCT_BY_NAME = "from Product where productName = :productName";
    private static final String FIND_PRODUCT_BY_ID = "from Product where id = :id";

    private static final String FIND_PRODUCT_BY_BARCODE = "select case when count(*) > 0  then 'true'  else 'false' end from Product where barcode = :barcode";
    private static final String PRODUCT_NAME = "productName";
    private static final String BARCODE = "barcode";
    private static final String FIND_PRODUCT_BY_PRODUCT_NAME = "select case when count(*) > 0  then 'true'  else 'false' end from Product where productName = :productName";


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findProduct(String productName) {
        return entityManager.createQuery(FIND_PRODUCT_BY_NAME, Product.class).setParameter(PRODUCT_NAME, productName).getSingleResult();
    }

    @Override
    public String findProductByBarcode(String barcode) {
        return entityManager.createQuery(FIND_PRODUCT_BY_BARCODE, String.class)
                .setParameter(BARCODE, barcode)
                .getSingleResult();
    }

    @Override
    public String findProductByName(String productName) {
        return entityManager.createQuery(FIND_PRODUCT_BY_PRODUCT_NAME, String.class)
                .setParameter(PRODUCT_NAME, productName)
                .getSingleResult();
    }

}
