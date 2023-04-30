package com.example.demo.product.controller;

import com.example.demo.product.controller.form.RequestProductForm;
import com.example.demo.product.entity.ProductEntity;
import com.example.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductProblemController {

    final private ProductService productService;

    @GetMapping("/list")
    public List<ProductEntity> listProduct() {
        List<ProductEntity> productList = productService.productList();

        return productList;
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        log.info("productRead()");

        productService.delete(productId);
    }

    @PostMapping("/register")
    public ProductEntity registerProduct(@RequestBody RequestProductForm requestProductForm) {
        log.info("registerProduct()");

        return productService.register(requestProductForm.toProductEntity());
    }

    @GetMapping("/{productId}")
    public ProductEntity readProduct(@PathVariable("productId") Long productId) {
        log.info("productRead()");
        return productService.read(productId);
    }

    @PutMapping("/{productId}")
    public ProductEntity modifyProduct (@PathVariable("productId") Long productId,
                                 @RequestBody RequestProductForm requestProductForm) {

        log.info("modifyProduct(): " + requestProductForm + ", id: " + productId);

        return productService.modify(productId, requestProductForm);

    }
}
