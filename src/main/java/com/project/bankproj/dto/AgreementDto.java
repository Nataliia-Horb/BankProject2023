package com.project.bankproj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Value
@Schema(description = "Entity of Agreement")
@Jacksonized
@Builder
@Data
@AllArgsConstructor
public class AgreementDto {

    @JsonProperty("interestRate")
    @NotNull
    @Min(0)
    @Schema(description = "interest rate", example = "10.55")
    BigDecimal interestRate;

    @JsonProperty("sum")
    @NotNull
    @Schema(description = "amount of money", example = "999.99")
    BigDecimal sum;

    @JsonProperty("accountId")
    @NotEmpty
    @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    @Schema(description = "Identifier", example = "b8ed7c33-b1cd-11ed-8545-08979887bb18")
    String accountId;

    @JsonProperty("productId")
    @NotNull
    @Min(0)
    @Schema(description = "Identifier", example = "1")
    int productId;
}