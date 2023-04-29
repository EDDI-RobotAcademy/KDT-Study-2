package com.example.demo.product.controller.form;

import com.example.demo.product.entity.JpaProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@RequiredArgsConstructor

public class RequestProductForm {
    private String name;
    private Integer price;
    private String company;
    private LocalDate manufactureDate;

    private String category;

    public JpaProduct toProductEntity(){

        return new JpaProduct(name,price,company,manufactureDate,category);
    }

}
