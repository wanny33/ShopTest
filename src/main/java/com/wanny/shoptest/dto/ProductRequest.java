package com.wanny.shoptest.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

public class ProductRequest {

    @NotNull
    private String productId;
    @NotNull
    private String productName;
    @NotNull
    private Integer price;
    @NotNull
    private Integer quantity;

    public String getProductId() { return productId; }

    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

}
