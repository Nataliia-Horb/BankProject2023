package com.project.bankproj.entity.enums;

import lombok.Getter;

@Getter
public enum ClientStatus {

    ACTIVE(0),
    PENDING(1),
    REMOVED(2),
    BLOCKED(3);
    private final int value;

    ClientStatus(int value) {
        this.value = value;
    }
}