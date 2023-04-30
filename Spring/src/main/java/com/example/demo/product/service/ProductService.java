package com.example.demo.product.service;

import com.example.demo.product.controller.form.RequestProductForm;
import com.example.demo.product.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> productList();

    ProductEntity read(Long productId);

    void delete(Long productId);

    ProductEntity register(ProductEntity productEntity);

    ProductEntity modify(Long productId, RequestProductForm requestProductForm);
}
