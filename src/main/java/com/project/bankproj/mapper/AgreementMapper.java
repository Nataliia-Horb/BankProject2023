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

    AgreementDto toDto(Agreement agreement);

    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "account", expression = "java(checkAccountId(accountId, accountRepository))")
    @Mapping(target = "product", expression = "java(checkProductId(productId, productRepository))")
    Agreement toEntity(AgreementDto agreement, int productId, ProductRepository productRepository,
                       UUID accountId, AccountRepository accountRepository);

    default Product checkProductId(int productId, ProductRepository productRepository) {
        return productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException(ErrorMessage.CURRENT_PRODUCT_NOT_FOUND));
    }

    default Account checkAccountId(UUID accountId, AccountRepository accountRepository) {
        return accountRepository.findAccountById(accountId).orElseThrow(
                () -> new AccountNotFoundException(ErrorMessage.CURRENT_ACCOUNT_NOT_FOUND));
    }
}