package com.project.bankproj.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.sql.Timestamp;

@Value
@Schema(description = "Entity of Product")
public class ProductDto {

    String id;

    String name;

    String status;

    String currency_code;

    String interestRate;

    String limit;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp updatedAt;

    ManagerDto manager;
}