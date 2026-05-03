package com.Twoeye.fincore_backend.infrastructure.product;

import com.Twoeye.fincore_backend.domain.product.Product;
import com.Twoeye.fincore_backend.domain.product.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface ProductJpaRepository extends JpaRepository<Product, String> {

    Page<Product> findByType(ProductType productType, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.isActive = true")
    Page<Product> findAllActive(Pageable pageable);
}
