package com.project.bankproj.entity.enums;

import lombok.Getter;

@Getter
public enum AccountStatus {

    ACTIVE(1),
    PENDING(2),
    BLOCKED(3),
    REMOVED(4);
    private final int value;

    AccountStatus(int value) {
        this.value = value;
    }
}