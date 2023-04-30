package com.example.demo.product.service;

import com.example.demo.product.entity.ProductEntity;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final private ProductRepository productRepository;

    
    @Override
     public ProductEntity read(Long productId) {
        Optional<ProductEntity> maybeProductEntity = productRepository.findById(productId);

        if(maybeProductEntity.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }
    

    @Override
    public List<ProductEntity> productList() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductEntity register(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
}
}