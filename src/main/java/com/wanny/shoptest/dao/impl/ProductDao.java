package com.wanny.shoptest.dao.impl;

import com.wanny.shoptest.dto.ProductRequest;
import com.wanny.shoptest.model.Product;

public interface ProductDao {

    Product getProductById(String productId);

    String createProduct(ProductRequest productRequest);
}
