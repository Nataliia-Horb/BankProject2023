package com.project.bankproj.controller;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Tag(name = "Product controller", description = "With a controller you can find all products or product by any " +
        "valid id")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "get Product By Id",
            description = "allows you to find  product by id (int)")
    public ProductDto getProduct(@PathVariable @Parameter(description =
            "enter the numerical value of productId") int productId) {
        return productService.getProductById(productId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "get allProducts",
            description = "allows you to get all products")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}