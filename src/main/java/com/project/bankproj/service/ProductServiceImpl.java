package com.project.bankproj.service;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Product;
import com.project.bankproj.mapper.ProductMapper;
import com.project.bankproj.repository.ProductRepository;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public ProductDto getProductById(int id) {
        log.info("Get product with id {}", id);
        return productMapper.toDto(productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException
                        ((ErrorMessage.CURRENT_PRODUCT_NOT_FOUND))));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        log.info("Get all products");
        List<Product> list = productRepository.findAll();
        return productMapper.productsDtoList(list);
    }
}
