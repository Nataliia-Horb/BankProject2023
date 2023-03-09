package com.project.bankproj.util;

import com.project.bankproj.entity.Manager;
import com.project.bankproj.entity.Product;
import com.project.bankproj.entity.enums.*;
import java.math.BigDecimal;

public class EntityCreator {

    public static Manager getManager() {
        Manager manager = new Manager();
        manager.setId(1);
        manager.setFirstName("FirstName");
        manager.setLastName("LastName");
        manager.setStatus(ManagerStatus.ACTIVE);
        return manager;
    }

    public static Product getProduct() {
        Product product=new Product();
        product.setId(1);
        product.setName("Mortgage");
        product.setStatus(ProductStatus.ACTIVE);
        product.setCurrency_code(Currencies.EUR);
        product.setInterestRate(new BigDecimal("12.5"));
        product.setLimit(10000);
       return product;
    }
}