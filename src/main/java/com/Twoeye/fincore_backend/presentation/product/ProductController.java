package com.Twoeye.fincore_backend.presentation.product;

import com.Twoeye.fincore_backend.application.product.ProductQueryService;
import com.Twoeye.fincore_backend.domain.product.ProductType;
import com.Twoeye.fincore_backend.presentation.common.ApiResponse;
import com.Twoeye.fincore_backend.presentation.common.OffsetPageResponse;
import com.Twoeye.fincore_backend.presentation.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductQueryService productQueryService;

    @GetMapping("/{productId}")
    public ApiResponse<ProductResponse> getProduct(@PathVariable String productId) {
        return ApiResponse.ok(ProductResponse.from(productQueryService.getProduct(productId)));
    }

    @GetMapping
    public ApiResponse<OffsetPageResponse<ProductResponse>> getProducts(
            @RequestParam(required = false) ProductType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        if (type != null) {
            return ApiResponse.ok(OffsetPageResponse.from(
                    productQueryService.getProductsByType(type, PageRequest.of(page, size)).map(ProductResponse::from)));
        }
        return ApiResponse.ok(OffsetPageResponse.from(
                productQueryService.getAllProducts(PageRequest.of(page, size)).map(ProductResponse::from)));
    }

    @GetMapping("/active")
    public ApiResponse<OffsetPageResponse<ProductResponse>> getActiveProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ApiResponse.ok(OffsetPageResponse.from(
                productQueryService.getActiveProducts(PageRequest.of(page, size)).map(ProductResponse::from)));
    }
}
