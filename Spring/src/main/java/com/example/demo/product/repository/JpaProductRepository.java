package com.example.demo.product.repository;

import com.example.demo.product.entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository  extends JpaRepository<JpaProduct, Long> {
} 
