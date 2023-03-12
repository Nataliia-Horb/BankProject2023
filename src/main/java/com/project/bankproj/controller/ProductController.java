package com.project.bankproj.controller;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ProductDto getProduct(@PathVariable("productId") int productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}