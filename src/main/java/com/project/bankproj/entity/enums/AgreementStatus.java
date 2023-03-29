package com.project.bankproj.entity.enums;

import lombok.Getter;

@Getter
public enum AgreementStatus {

    ACTIVE(0),
    PENDING(1),
    BLOCKED(2),
    REMOVED(3);
    private final int value;

    AgreementStatus(int value) {
        this.value = value;
    }
}