package com.project.bankproj.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.sql.Timestamp;

@Value
@Schema(description = "Entity of Account")
public class AccountDto {

    String id;

    String name;

    String type;

    String status;

    String balance;

    String currency_code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp updatedAt;

    ClientDto client;
}