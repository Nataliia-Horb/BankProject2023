package com.project.bankproj.service.impl;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.entity.Agreement;
import com.project.bankproj.exception.AgreementNotFoundException;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.mapper.AgreementMapper;
import com.project.bankproj.repository.AccountRepository;
import com.project.bankproj.repository.AgreementRepository;
import com.project.bankproj.repository.ProductRepository;
import com.project.bankproj.service.AgreementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepository agreementRepository;
    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;
    private final AgreementMapper agreementMapper;

    @Override
    public void save(AgreementDto newAgreementDto) {
        Agreement newAgreement = agreementMapper.toEntity(newAgreementDto, newAgreementDto.getProductId(),
                productRepository, UUID.fromString(newAgreementDto.getAccountId()), accountRepository);
        log.info("Create agreement {}", newAgreement);
        agreementRepository.save(newAgreement);

    }

    @Override
    public AgreementDto delete(int agreementId) {
        Agreement agreement = agreementRepository.findById(agreementId).orElseThrow(
                () -> new AgreementNotFoundException(ErrorMessage.CURRENT_AGREEMENT_NOT_FOUND));
        agreementRepository.delete(agreement);
        log.info("Delete agreement {}", agreement);
        return agreementMapper.toDto(agreement);
    }
}