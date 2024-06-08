package com.wanny.shoptest.service.impl;

import com.wanny.shoptest.dto.ProductRequest;
import com.wanny.shoptest.model.Product;

public interface ProductService {

    Product getProductById(String productId);

    String createProduct(ProductRequest productRequest);

}
