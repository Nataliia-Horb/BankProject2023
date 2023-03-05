package com.project.bankproj.entity.enums;

public enum AgreementStatus {
    ACTIVE(1),
    PENDING(2),
    BLOCKED(3),
    REMOVED(4);
    private int value;

    AgreementStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
