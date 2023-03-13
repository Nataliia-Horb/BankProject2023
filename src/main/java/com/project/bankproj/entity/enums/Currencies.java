package com.project.bankproj.entity.enums;

import lombok.Getter;

@Getter
public enum Currencies {

    EUR(1),
    USD(2),
    UAH(3),
    RUB(4);
    private final int value;

    Currencies(int value) {
        this.value = value;
    }
}