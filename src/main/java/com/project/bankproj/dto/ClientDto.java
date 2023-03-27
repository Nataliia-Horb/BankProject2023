package com.project.bankproj.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(description = "Entity of Client")
public class ClientDto {

    String id;

    String firstName;

    String lastName;

    String email;

    String address;

    String phone;
}