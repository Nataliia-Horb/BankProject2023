package com.project.bankproj.dto;

import com.project.bankproj.entity.enums.ManagerStatus;
import lombok.Value;
import java.sql.Timestamp;

@Value
public class ManagerDto {
    int id;

    String firstName;

    String lastName;

    ManagerStatus status;

    Timestamp createdAt;

    Timestamp updatedAt;

}
