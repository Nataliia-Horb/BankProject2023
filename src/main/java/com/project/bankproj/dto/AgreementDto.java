package com.project.bankproj.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;

@Value
public class AgreementDto {

    @NotNull
    @Min(0)
    BigDecimal interestRate;

    @NotNull
    BigDecimal sum;

    @NotEmpty
    @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    String accountId;

    @NotNull
    @Min(0)
    int productId;
}