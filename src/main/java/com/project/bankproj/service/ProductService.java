package com.project.bankproj.service;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.dto.ProductListDto;

public interface ProductService {
    ProductDto getProductById(int id);

//    void deleteProduct (int id);

    ProductListDto getAllProducts();

}
