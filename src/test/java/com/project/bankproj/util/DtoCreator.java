package com.project.bankproj.util;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoCreator {

    public static ProductDto getProductDto() {
        Product product = EntityCreator.getProduct();
        return new ProductDto(
                String.valueOf(product.getId()),
                String.valueOf(product.getName()),
                String.valueOf(product.getStatus()),
                String.valueOf(product.getCurrency_code()),
                String.valueOf(product.getInterestRate()),
                String.valueOf(product.getLimit()),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getManager()
        );
    }
}