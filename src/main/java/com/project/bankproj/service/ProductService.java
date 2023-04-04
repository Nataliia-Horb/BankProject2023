package com.project.bankproj.service;

import com.project.bankproj.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(int id);

    List<ProductDto> getAllProducts();
}