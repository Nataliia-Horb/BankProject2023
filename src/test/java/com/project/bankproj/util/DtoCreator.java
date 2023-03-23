package com.project.bankproj.util;

import com.project.bankproj.dto.*;
import com.project.bankproj.entity.*;
import lombok.experimental.UtilityClass;


@UtilityClass
public class DtoCreator {

    public static ManagerDto getManagerDto() {
        Manager manager = EntityCreator.getManager();
        return new ManagerDto(
                String.valueOf(manager.getId()),
                manager.getFirstName(),
                manager.getLastName(),
                String.valueOf(manager.getStatus())
        );
    }

    public static ProductDto getProductDto() {
        Product product = EntityCreator.getProduct();
        return new ProductDto(
                String.valueOf(product.getId()),
                product.getName(),
                String.valueOf(product.getStatus()),
                String.valueOf(product.getCurrency_code()),
                String.valueOf(product.getInterestRate()),
                String.valueOf(product.getLimit()),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                getManagerDto()
        );
    }


    public static ClientDto getClientDto() {
        Client client = EntityCreator.getClient();
        return new ClientDto(
                String.valueOf(client.getId()),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getAddress(),
                client.getPhone()
        );
    }


    public static AccountDto getAccountDto() {
        Account account = EntityCreator.getAccount();
        return new AccountDto(
                account.getId().toString(),
                account.getName(),
                String.valueOf(account.getType()),
                String.valueOf(account.getStatus()),
                String.valueOf(account.getBalance()),
                String.valueOf(account.getCurrency_code()),
                account.getCreatedAt(),
                account.getUpdatedAt(),
                getClientDto()
        );
    }

    public static AgreementDto getAgreementDto() {
        Agreement agreement = EntityCreator.getAgreement();
        return new AgreementDto(
                agreement.getInterestRate(),
                agreement.getSum(),
                agreement.getAccount().getId().toString(),
                agreement.getProduct().getId()
        );
    }

    public static TransactionDto getTransactionDto() {
        Transaction transaction = EntityCreator.getTransaction();
        return new TransactionDto(
                String.valueOf(transaction.getId()),
                String.valueOf(transaction.getType()),
                String.valueOf(transaction.getAmount()),
                transaction.getDescription(),
                transaction.getCreatedAt(),
                transaction.getDebitAccountId().getId().toString(),
                transaction.getCreditAccountId().getId().toString()
        );
    }
}