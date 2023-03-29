package com.project.bankproj.entity.enums;

import lombok.Getter;

@Getter
public enum ManagerStatus {

    ACTIVE(0),
    PENDING(1),
    REMOVED(2);
    private final int value;

    ManagerStatus(int value) {
        this.value = value;
    }
}