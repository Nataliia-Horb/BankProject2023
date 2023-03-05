package com.project.bankproj.dto;

import com.project.bankproj.entity.enums.Currencies;
import com.project.bankproj.entity.enums.ProductStatus;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Value
public class ProductDto {

    int id;

    String name;

    ProductStatus status;

    Currencies currency_code;

    BigDecimal interestRate;

    int limit;

    Timestamp createdAt;

    Timestamp updatedAt;

    ManagerDto manager;

}