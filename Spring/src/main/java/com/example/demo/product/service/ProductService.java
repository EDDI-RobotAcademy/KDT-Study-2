package com.example.demo.product.service;

import com.example.demo.product.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> productList();
    void delete(Long productId);
    ProductEntity register(ProductEntity productEntity);
}
