package com.project.bankproj.util;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Account;
import com.project.bankproj.entity.Agreement;
import com.project.bankproj.entity.Product;
import lombok.experimental.UtilityClass;


@UtilityClass
public class DtoCreator {

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
                product.getManager()
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
                account.getUpdatedAt()
        );
    }

    public static AgreementDto getAgreementDto() {
        Agreement agreement = EntityCreator.getAgreement();
        return new AgreementDto(
                agreement.getId(),
                agreement.getInterestRate(),
                agreement.getSum(),
                agreement.getAccount().getId().toString(),
                agreement.getProduct().getId()
        );
    }
}