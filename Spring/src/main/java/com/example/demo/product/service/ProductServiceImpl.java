package com.example.demo.product.service;

import com.example.demo.product.controller.form.RequestProductForm;
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
    public ProductEntity modify(Long productId, RequestProductForm requestProductForm) {

        Optional<ProductEntity> maybeProductEntity = productRepository.findById(productId);

        if (maybeProductEntity.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        ProductEntity productEntity = maybeProductEntity.get();

        productEntity.setName(requestProductForm.getName());
        productEntity.setPrice(requestProductForm.getPrice());
        productEntity.setCompany(requestProductForm.getCompany());
        productEntity.setManufactureDate(requestProductForm.getManufactureDate());
        productEntity.setCategory(requestProductForm.getCategory());

        return productRepository.save(productEntity);

    }

}