package com.project.bankproj.entity.enums;

import lombok.Getter;

@Getter
public enum AccountType {

    CREDIT(1),
    DEPOSIT(2),
    CURRENT(3);
    private final int value;

    AccountType(int value) {
        this.value = value;
    }
}