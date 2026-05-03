package com.Twoeye.fincore_backend.domain.product.exception;

import com.Twoeye.fincore_backend.domain.common.exception.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {

    public ProductNotFoundException(String productId) {
        super("상품을 찾을 수 없습니다. productId=" + productId);
    }
}
