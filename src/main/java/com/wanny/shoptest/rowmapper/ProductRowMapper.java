package com.wanny.shoptest.rowmapper;

import com.wanny.shoptest.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getString("Product_Id"));
        product.setProductName(resultSet.getString("Product_Name"));
        product.setPrice(resultSet.getInt("Price"));
        product.setQuantity(resultSet.getInt("Quantity"));

        return product;
    }
}
