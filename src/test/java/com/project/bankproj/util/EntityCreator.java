package com.project.bankproj.util;

import com.project.bankproj.entity.*;
import com.project.bankproj.entity.enums.*;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.UUID;

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

        Product product = new Product();
        product.setId(1);
        product.setName("Mortgage");
        product.setStatus(ProductStatus.ACTIVE);
        product.setCurrency_code(Currencies.EUR);
        product.setInterestRate(new BigDecimal("12.5"));
        product.setLimit(10000);
        product.setManager(getManager());
        return product;
    }

    public static Client getClient() {

        Client client = new Client();
        client.setId(UUID.fromString("4c15d4b3-b1d3-11ed-8545-08979887bb18"));
        client.setStatus(ClientStatus.ACTIVE);
        client.setTaxCode("8254798798798");
        client.setFirstName("Peter");
        client.setLastName("Braun");
        client.setEmail("peterBraun@gmail.com");
        client.setAddress("Tina-Schütz-Gasse 5/4 24476");
        client.setPhone("+49(0)3237775284");
        client.setManager(getManager());
        return client;
    }

    public static Account getAccount() {

        Account account = new Account();
        account.setId(UUID.fromString("4ce519a0-b1d5-11ed-8545-08979887bb18"));
        account.setName("Account_Person1");
        account.setType(AccountType.CREDIT);
        account.setStatus(AccountStatus.ACTIVE);
        account.setBalance(new BigDecimal(10000));
        account.setCurrency_code(Currencies.EUR);
        account.setClient(getClient());
        return account;
    }

    public static Agreement getAgreement() {

        Agreement agreement = new Agreement();
        agreement.setId(1);
        agreement.setInterestRate(new BigDecimal(12));
        agreement.setStatus(AgreementStatus.ACTIVE);
        agreement.setSum(new BigDecimal(1500));
        agreement.setAccount(getAccount());
        agreement.setProduct(getProduct());
        return agreement;
    }
}