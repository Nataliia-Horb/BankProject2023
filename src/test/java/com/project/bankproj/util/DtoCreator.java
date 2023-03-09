package com.project.bankproj.util;

import com.project.bankproj.dto.ManagerDto;
import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Manager;
import com.project.bankproj.entity.Product;
import java.sql.Timestamp;

public class DtoCreator {

    public static ManagerDto getManagerDto() {
        Manager manager = EntityCreator.getManager();
        return new ManagerDto(
                manager.getId(),
                manager.getFirstName(),
                manager.getLastName(),
                manager.getStatus(),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis())
        );
    }

    public static ProductDto getProductDto() {
        Product product = EntityCreator.getProduct();
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getStatus(),
                product.getCurrency_code(),
                product.getInterestRate(),
                product.getLimit(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                getManagerDto()
        );
    }
}