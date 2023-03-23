package com.project.bankproj.dto;

import lombok.Value;

@Value
public class ClientDto {

    String id;

    String firstName;

    String lastName;

    String email;

    String address;

    String phone;
}