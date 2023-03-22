package com.project.bankproj.mapper;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.entity.Account;
import com.project.bankproj.entity.Agreement;
import com.project.bankproj.entity.Product;
import com.project.bankproj.exception.AccountNotFoundException;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.exception.ProductNotFoundException;
import com.project.bankproj.repository.AccountRepository;
import com.project.bankproj.repository.ProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface AgreementMapper {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "account.id", target = "accountId")
    AgreementDto toDto(Agreement agreement);


    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "account", expression = "java(checkAccountId(agreement, accountRepository))")
    @Mapping(target = "product", expression = "java(checkProductId(agreement, productRepository))")
    Agreement toEntity(AgreementDto agreement, ProductRepository productRepository,
                       AccountRepository accountRepository);


    default Product checkProductId(AgreementDto agreement, ProductRepository productRepository) {
        return productRepository.findById(agreement.getProductId()).orElseThrow(
                () -> new ProductNotFoundException(ErrorMessage.CURRENT_PRODUCT_NOT_FOUND));
    }

    default Account checkAccountId(AgreementDto agreement, AccountRepository accountRepository) {
        return accountRepository.findAccountById(UUID.fromString(agreement.getAccountId())).orElseThrow(
                () -> new AccountNotFoundException(ErrorMessage.CURRENT_ACCOUNT_NOT_FOUND));
    }
}