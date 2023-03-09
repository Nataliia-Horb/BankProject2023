package com.project.bankproj.mapper;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Product;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test class for ProductMapper")
class ProductMapperTest {
    private final ProductMapper productMapper = new ProductMapperImpl();

    @Test
    @DisplayName("When we have correct product then return correct ProductDto")
    void toDto() {
        Product product = EntityCreator.getProduct();

        ProductDto currentProductDto=productMapper.toDto(product);

        compareEntityWithDto(product, currentProductDto);
    }

    @Test
    @DisplayName("When we have correct list of Accounts then return correct list of AccountDto")
    void toDtoList() {
        List<Product> productList = new ArrayList<>();
        productList.add(EntityCreator.getProduct());

        List<ProductDto> productDtoList = productMapper.productsDtoList(productList);

        compareProductListWithProductListDto(productList, productDtoList);
    }

    private void compareEntityWithDto(Product product, ProductDto productDto) {
        assertAll(
                () -> assertEquals(product.getId(), productDto.getId()),
                () -> assertEquals(product.getName(), productDto.getName()),
                () -> assertEquals(product.getStatus(), productDto.getStatus()),
                () -> assertEquals(product.getCurrency_code(), productDto.getCurrency_code()),
                () -> assertEquals(product.getInterestRate(), productDto.getInterestRate()),
                () -> assertEquals(product.getCreatedAt(), productDto.getCreatedAt()),
                () -> assertEquals(product.getUpdatedAt(), productDto.getUpdatedAt())
//                () -> assertEquals(product.getManager(), productDto.getManager())
        );
    }

    private void compareProductListWithProductListDto(List<Product> productList, List<ProductDto> productDtoList) {
        assertEquals(productList.size(), productDtoList.size());
        for (int i = 0; i < productList.size(); i++) {
            compareEntityWithDto(productList.get(i), productDtoList.get(i));
        }
    }
}