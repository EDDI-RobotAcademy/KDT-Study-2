package com.example.demo.product.controller;

import com.example.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductProblemController {

    final private ProductService productService;

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        log.info("productRead()");

        productService.delete(productId);
    }

    @PostMapping("/register")
    public ProductEntity registerProduct(@RequestBody RequestProductForm requestProductForm){
        log.info("registerProduct()");

        productService.delete(productId);
    }
}
