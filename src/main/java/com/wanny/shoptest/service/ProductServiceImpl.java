package com.wanny.shoptest.service;

import com.wanny.shoptest.dao.impl.ProductDao;
import com.wanny.shoptest.dto.ProductRequest;
import com.wanny.shoptest.model.Product;
import com.wanny.shoptest.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(String productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public String createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
