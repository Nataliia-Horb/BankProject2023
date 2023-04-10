package com.project.bankproj.mapper;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.dto.AgreementResponseDto;
import com.project.bankproj.entity.Account;
import com.project.bankproj.entity.Agreement;
import com.project.bankproj.entity.Product;
import com.project.bankproj.repository.AccountRepository;
import com.project.bankproj.repository.ProductRepository;
import com.project.bankproj.util.DtoCreator;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("Test class for AgreementMapper")
@ExtendWith(MockitoExtension.class)
public class AgreementMapperTest {

    AgreementMapper agreementMapper = new AgreementMapperImpl();

    @Mock
    ProductRepository productRepository;

    @Mock
    AccountRepository accountRepository;

    @Test
    @DisplayName("When we have correct agreementDto then return correct agreement")
    void toEntity() {
        Agreement agreement = EntityCreator.getAgreement();
        AgreementDto agreementDto = DtoCreator.getAgreementDto();
        Product product = EntityCreator.getProduct();
        Account account = EntityCreator.getAccount();
        int productId = product.getId();
        UUID accountId = account.getId();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(accountRepository.findAccountById(accountId)).thenReturn(Optional.of(account));

        Agreement currentAgreement = agreementMapper.toEntity(agreementDto, productRepository, accountRepository);

        assertAll(
                () -> assertEquals(agreement.getInterestRate(), currentAgreement.getInterestRate()),
                () -> assertEquals(agreement.getStatus(), currentAgreement.getStatus()),
                () -> assertEquals(agreement.getSum(), currentAgreement.getSum()),
                () -> assertEquals(agreement.getCreatedAt(), currentAgreement.getCreatedAt()),
                () -> assertEquals(agreement.getUpdatedAt(), currentAgreement.getUpdatedAt()),
                () -> assertEquals(agreement.getAccount(), currentAgreement.getAccount()),
                () -> assertEquals(agreement.getProduct(), currentAgreement.getProduct())
        );
    }

    @Test
    @DisplayName("When we have correct agreementDto then return correct agreement")
    void toDto() {
        Agreement agreement = EntityCreator.getAgreement();
        AgreementDto agreementDto = DtoCreator.getAgreementDto();

        AgreementDto currentAgreementDto = agreementMapper.toDto(agreement);

        assertAll(
                () -> assertEquals(agreementDto.getInterestRate(), currentAgreementDto.getInterestRate()),
                () -> assertEquals(agreementDto.getSum(), currentAgreementDto.getSum()),
                () -> assertEquals(agreementDto.getAccountId(), currentAgreementDto.getAccountId()),
                () -> assertEquals(agreementDto.getProductId(), currentAgreementDto.getProductId())
        );
    }

    @Test
    @DisplayName("When we have correct agreement then return correct agreementResponseDto")
    void toResponseDto() {
        Agreement agreement = EntityCreator.getAgreement();
        AgreementResponseDto agreementDto = DtoCreator.getAgreementResponseDto();

        AgreementResponseDto currentAgreementDto = agreementMapper.toResponseDto(agreement);

        assertAll(
                () -> assertEquals(agreementDto.getId(), currentAgreementDto.getId()),
                () -> assertEquals(agreementDto.getInterestRate(), currentAgreementDto.getInterestRate()),
                () -> assertEquals(agreementDto.getStatus(), currentAgreementDto.getStatus()),
                () -> assertEquals(agreementDto.getSum(), currentAgreementDto.getSum()),
                () -> assertEquals(agreementDto.getAccount().getId(), currentAgreementDto.getAccount().getId()),
                () -> assertEquals(agreementDto.getProduct().getId(), currentAgreementDto.getProduct().getId())
        );
    }
}