package com.wanny.shoptest.dao;

import com.wanny.shoptest.dao.impl.ProductDao;
import com.wanny.shoptest.dto.ProductRequest;
import com.wanny.shoptest.model.Product;
import com.wanny.shoptest.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(String productId) {
        String sql = "SELECT Product_ID, Product_Name, Price, Quantity" +
                     "FROM product WHERE Product_ID = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public String createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO Product(Product_Id, Product_Name, Price, Quantity)" +
                     "VALUES (:productId, :productName, :price, :quantity)";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productRequest.getProductId());
        map.put("productName", productRequest.getProductName());
        map.put("price", productRequest.getPrice());
        map.put("quantity", productRequest.getQuantity());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        String productId = new String(keyHolder.getKey().toString());

        return productId;
    }
}
