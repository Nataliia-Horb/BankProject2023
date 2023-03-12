package com.project.bankproj.util;

import com.project.bankproj.entity.Manager;
import com.project.bankproj.entity.Product;
import com.project.bankproj.entity.enums.*;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.sql.Timestamp;

@UtilityClass
public class EntityCreator {

    private static Manager getManager() {
        Manager manager = new Manager();
        manager.setId(1);
        manager.setFirstName("FirstName");
        manager.setLastName("LastName");
        manager.setStatus(ManagerStatus.ACTIVE);
        return manager;
    }

    public static Product getProduct() {
        Timestamp time = new Timestamp(380668882788L);
        Product product = new Product();
        product.setId(1);
        product.setName("Mortgage");
        product.setStatus(ProductStatus.ACTIVE);
        product.setCurrency_code(Currencies.EUR);
        product.setInterestRate(new BigDecimal("12.5"));
        product.setLimit(10000);
        product.setCreatedAt(time);
        product.setUpdatedAt(time);
        product.setManager(getManager());
        return product;
    }
}