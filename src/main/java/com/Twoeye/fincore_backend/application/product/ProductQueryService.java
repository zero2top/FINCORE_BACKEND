package com.Twoeye.fincore_backend.application.product;

import com.Twoeye.fincore_backend.domain.product.Product;
import com.Twoeye.fincore_backend.domain.product.ProductRepository;
import com.Twoeye.fincore_backend.domain.product.ProductType;
import com.Twoeye.fincore_backend.domain.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductQueryService {

    private final ProductRepository productRepository;

    public Product getProduct(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Page<Product> getProductsByType(ProductType type, Pageable pageable) {
        return productRepository.findByCategoryId(pageable, type);
    }

    public Page<Product> getActiveProducts(Pageable pageable) {
        return productRepository.findActiveProducts(pageable);
    }
}
