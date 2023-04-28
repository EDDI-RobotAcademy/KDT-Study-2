package com.example.demo.product.controller;



import com.example.demo.product.controller.form.RequestProductForm;
import com.example.demo.product.entity.ProductEntity;
import com.example.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductProblemController {

    final private ProductService productService;

    @PostMapping("/register")
    public ProductEntity registerProduct(@RequestBody RequestProductForm requestProductForm){
        log.info("registerProduct()");

        return productService.register(requestProductForm.toProductEntity());
    }


}
