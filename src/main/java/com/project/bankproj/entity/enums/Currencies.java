package com.project.bankproj.entity.enums;

import lombok.Getter;

@Getter
public enum Currencies {

    EUR(0),
    USD(1),
    UAH(2),
    RUB(3);
    private final int value;

    Currencies(int value) {
        this.value = value;
    }

    public static Currencies getCurrency(int id) {
        for (Currencies c : Currencies.values()) {
            if (c.value == id) {
                return c;
            }
        }
        return null;
    }
}