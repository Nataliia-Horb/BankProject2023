package com.project.bankproj.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.sql.Timestamp;

@Value
@Schema(description = "Entity of Agreement by response")
public class AgreementResponseDto {

    String id;

    String interestRate;

    String status;

    String sum;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp updatedAt;

    AccountDto account;

    ProductDto product;
}