package com.project.bankproj.service;
import com.project.bankproj.dto.ProductDto;

import com.project.bankproj.dto.ProductListDto;
import com.project.bankproj.entity.Product;
import com.project.bankproj.mapper.ProductMapper;
import com.project.bankproj.repository.ProductRepository;
import com.project.bankproj.service.exception.ErrorMessage;
import com.project.bankproj.service.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getProductById(int id) {
        log.info("Get product with id {}", id);
        return productMapper.toDto(productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException
                        ((ErrorMessage.CURRENT_PRODUCT_NOT_FOUND))));
    }


//    @Override
//    public void deleteProduct(int id) {
//        log.info("Delete product by id {}", id);
//       Product product=productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException
//                ((ErrorMessage.CURRENT_PRODUCT_NOT_FOUND)));
//       if (product!=null){
//           productRepository.delete(product);
//       }
//    }


    @Override
    public ProductListDto getAllProducts() {
        log.info("Get all products");
        List<Product> list = productRepository.findAll();
            return new ProductListDto(productMapper.productsDtoList(list));
    }
}
