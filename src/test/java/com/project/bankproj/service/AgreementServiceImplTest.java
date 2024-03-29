package com.project.bankproj.service;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.dto.AgreementResponseDto;
import com.project.bankproj.entity.Agreement;
import com.project.bankproj.exception.AgreementNotFoundException;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.mapper.AgreementMapper;
import com.project.bankproj.repository.AccountRepository;
import com.project.bankproj.repository.AgreementRepository;
import com.project.bankproj.repository.ProductRepository;
import com.project.bankproj.service.impl.AgreementServiceImpl;
import com.project.bankproj.util.DtoCreator;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@DisplayName("Test class for AgreementServiceImpl")
@ExtendWith(MockitoExtension.class)
public class AgreementServiceImplTest {

    @Mock
    AgreementRepository repository;

    @Mock
    ProductRepository productRepository;

    @Mock
    AccountRepository accountRepository;

    @Mock
    AgreementMapper mapper;

    @InjectMocks
    AgreementServiceImpl agreementService;

    @Test
    void save() {
        Agreement newAgreement = EntityCreator.getAgreement();
        AgreementDto newAgreementDto = DtoCreator.getAgreementDto();
        AgreementResponseDto agreementResponseDto = DtoCreator.getAgreementResponseDto();
        when(repository.save(newAgreement)).thenReturn(newAgreement);
        when(mapper.toEntity(newAgreementDto, productRepository,
                accountRepository)).thenReturn(newAgreement);
        when(mapper.toResponseDto(newAgreement)).thenReturn(agreementResponseDto);

        AgreementResponseDto currentAgreement = agreementService.save(newAgreementDto);

        assertEquals(agreementResponseDto, currentAgreement);
        verify(repository, times(1)).save(newAgreement);
    }

    @Test
    void delete() {
        Agreement newAgreement = EntityCreator.getAgreement();
        int agreementId = newAgreement.getId();
        when(repository.existsById(agreementId)).thenReturn(true);
        doNothing().when(repository).deleteById(agreementId);

        agreementService.delete(agreementId);

        verify(repository, times(1)).existsById(agreementId);
        verify(repository, times(1)).deleteById(agreementId);
    }

    @Test
    void throwExceptionIfNotFindAgreementIdByDelete() {
        int agreementId = 10;
        when(repository.existsById(agreementId)).thenReturn(false);

        assertThrows(AgreementNotFoundException.class, () -> agreementService.delete(agreementId));
        verify(repository, times(1)).existsById(agreementId);
    }

    @Test
    void throwExceptionIfNotFindAgreementIdBySave() {
        Exception exception = assertThrows(AgreementNotFoundException.class, () -> agreementService.delete(33));
        assertEquals(ErrorMessage.CURRENT_AGREEMENT_NOT_FOUND, exception.getMessage());
    }
}