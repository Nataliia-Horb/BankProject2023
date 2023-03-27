package com.project.bankproj.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;


@Value
@Schema(description = "Entity of Manager")
public class ManagerDto {
    String id;

    String firstName;

    String lastName;

    String status;
}