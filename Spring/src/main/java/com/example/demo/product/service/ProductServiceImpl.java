package com.example.demo.product.service;

import com.example.demo.product.entity.ProductEntity;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final private ProductRepository productRepository;


    @Override
    public ProductEntity register(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
    @Override
    public ProductEntity read(Long productId) {
        Optional<ProductEntity> maybeProductEntity = productRepository.findById(productId);

        if (maybeProductEntity.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeProductEntity.get();
    }


    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

}
