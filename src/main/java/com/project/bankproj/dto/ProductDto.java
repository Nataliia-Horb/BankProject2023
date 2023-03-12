package com.project.bankproj.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

@Value
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

    String manager;
}