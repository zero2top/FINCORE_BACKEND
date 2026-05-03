package com.Twoeye.fincore_backend.infrastructure.product;

import com.Twoeye.fincore_backend.domain.product.Product;
import com.Twoeye.fincore_backend.domain.product.ProductRepository;
import com.Twoeye.fincore_backend.domain.product.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository jpaRepository;

    @Override
    public Product save(Product product) {
        return jpaRepository.save(product);
    }

    @Override
    public Optional<Product> findById(String productId) {
        return jpaRepository.findById(productId);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByCategoryId(Pageable pageable, ProductType productType) {
        return jpaRepository.findByType(productType, pageable);
    }

    @Override
    public Page<Product> findActiveProducts(Pageable pageable) {
        return jpaRepository.findAllActive(pageable);
    }
}
