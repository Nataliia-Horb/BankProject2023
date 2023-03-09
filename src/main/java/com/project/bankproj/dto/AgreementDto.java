package com.project.bankproj.dto;

import lombok.*;
import java.math.BigDecimal;

@Value
public class AgreementDto {

    int id;

    BigDecimal interestRate;

    BigDecimal sum;

    String accountId;

    int productId;
}