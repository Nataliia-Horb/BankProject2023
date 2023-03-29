package com.project.bankproj.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import java.sql.Timestamp;

@Value
@Schema(description = "Entity of Transaction")
public class TransactionDto {
    String id;

    String type;

    String amount;

    String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp createdAt;

    String debitAccountId;

    String creditAccountId;
}