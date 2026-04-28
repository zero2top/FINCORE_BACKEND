package com.Twoeye.fincore_backend.domain.product;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(String productId);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByCategoryId(Pageable pageable, ProductType productType);

    Page<Product> findActiveProducts(Pageable pageable); // 판매중인 상품만 보기
}
