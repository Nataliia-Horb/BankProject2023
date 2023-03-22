package com.project.bankproj.service;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Product;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.exception.ProductNotFoundException;
import com.project.bankproj.mapper.ProductMapper;
import com.project.bankproj.repository.ProductRepository;
import com.project.bankproj.service.impl.ProductServiceImpl;
import com.project.bankproj.util.DtoCreator;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("Test class for AccountServiceImpl")
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    ProductRepository repository;
    @Mock
    ProductMapper mapper;
    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void getProductById() {
        Product product = EntityCreator.getProduct();
        ProductDto productDto = DtoCreator.getProductDto();
        when(repository.findById(product.getId())).thenReturn(Optional.of(product));
        when(mapper.toDto(product)).thenReturn(productDto);

        ProductDto currentProductDto = productService.getProductById(product.getId());

        assertEquals(productDto, currentProductDto);
        verify(repository, times(1)).findById(product.getId());
    }

    @Test
    void getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(EntityCreator.getProduct());
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(DtoCreator.getProductDto());
        when(repository.findAll()).thenReturn(products);
        when(mapper.toDtoList(products)).thenReturn(productDtoList);

        List<ProductDto> currentProductDtoList = productService.getAllProducts();

        assertEquals(productDtoList, currentProductDtoList);
        verify(repository, times(1)).findAll();
    }


    @Test
    void throwExceptionIfNotFindProductId() {
        Exception exception = assertThrows(ProductNotFoundException.class, () -> productService.getProductById(3));
        assertEquals(ErrorMessage.CURRENT_PRODUCT_NOT_FOUND, exception.getMessage());
    }

    @Test
    void throwExceptionIfProductsListIsEmpty() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        Exception exception = assertThrows(ProductNotFoundException.class, () -> productService.getAllProducts());
        assertEquals(ErrorMessage.PRODUCTS_NOT_FOUND, exception.getMessage());
    }
}