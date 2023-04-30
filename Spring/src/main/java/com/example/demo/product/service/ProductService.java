package com.example.demo.product.service;

import com.example.demo.product.entity.ProductEntity;

public interface ProductService {


    ProductEntity read(Long productId);


    
    void delete(Long productId);
    ProductEntity register(ProductEntity productEntity);


}
