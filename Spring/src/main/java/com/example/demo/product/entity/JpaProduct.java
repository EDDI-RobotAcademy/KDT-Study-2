//package com.example.demo.product.entity;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity
//@Getter
//@ToString
//@NoArgsConstructor
//public class JpaProduct {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public Long productId;
//
//    @Setter
//    private String name;
//
//    @Setter
//    private Integer price;
//
//    @Setter
//    private String company;
//
//    private Date expDate;
//
//    private Integer category;
//
//    public JpaProduct(String name, Integer price, String company, Date manufactureDate, Integer category) {
//        this.name = name;
//        this.price = price;
//        this.company = company;
//        this.category = category;
//    }
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
//    @CreationTimestamp
//    private Date manufactureDate;
//
//}
