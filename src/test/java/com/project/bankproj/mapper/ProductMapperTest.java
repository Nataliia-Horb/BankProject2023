package com.project.bankproj.mapper;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Product;
import com.project.bankproj.util.DtoCreator;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test class for ProductMapper")
@ExtendWith(MockitoExtension.class)
class ProductMapperTest {
    ProductMapper productMapper = new ProductMapperImpl();

    @Test
    @DisplayName("When we have correct product then return correct ProductDto")
    void toDto() {
        Product product = EntityCreator.getProduct();
        ProductDto productDto = DtoCreator.getProductDto();

        ProductDto currentProductDto = productMapper.toDto(product);

        compareDtoWithCurrentDto(productDto, currentProductDto);
    }

    @Test
    @DisplayName("When we have correct list of product then return correct list of productDto")
    void toDtoList() {
        List<Product> productList = new ArrayList<>();
        productList.add(EntityCreator.getProduct());
        ProductDto productDto = DtoCreator.getProductDto();
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(productDto);

        List<ProductDto> currentProductDtoList = productMapper.toDtoList(productList);

        compareProductListWithProductListDto(productDtoList, currentProductDtoList);
    }

    private void compareDtoWithCurrentDto(ProductDto productDto, ProductDto currentProductDto) {
        assertAll(
                () -> assertEquals(productDto.getId(), currentProductDto.getId()),
                () -> assertEquals(productDto.getName(), currentProductDto.getName()),
                () -> assertEquals(productDto.getStatus(), currentProductDto.getStatus()),
                () -> assertEquals(productDto.getCurrency_code(), currentProductDto.getCurrency_code()),
                () -> assertEquals(productDto.getInterestRate(), currentProductDto.getInterestRate()),
                () -> assertEquals(productDto.getCreatedAt(), currentProductDto.getCreatedAt()),
                () -> assertEquals(productDto.getUpdatedAt(), currentProductDto.getUpdatedAt()),
                () -> assertEquals(productDto.getManager(), currentProductDto.getManager())
        );
    }

    private void compareProductListWithProductListDto(List<ProductDto> productDtoList, List<ProductDto> currentProductDtoList) {
        assertEquals(productDtoList.size(), currentProductDtoList.size());
        for (int i = 0; i < productDtoList.size(); i++) {
            compareDtoWithCurrentDto(productDtoList.get(i), currentProductDtoList.get(i));
        }
    }
}