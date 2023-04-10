package com.project.bankproj.service.impl;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.dto.AgreementResponseDto;
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

@Service
@Slf4j
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepository agreementRepository;
    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;
    private final AgreementMapper agreementMapper;

    @Override
    public AgreementResponseDto save(AgreementDto newAgreementDto) {
        Agreement newAgreement = agreementMapper.toEntity(newAgreementDto,
                productRepository, accountRepository);
        log.info("Create agreement {}", newAgreement);
        return agreementMapper.toResponseDto(agreementRepository.save(newAgreement));
    }

    @Override
    public void delete(int agreementId) {
        if (agreementRepository.existsById(agreementId)) {
            log.info("Delete agreement with id {}", agreementId);
            agreementRepository.deleteById(agreementId);
        } else {
            throw new AgreementNotFoundException(ErrorMessage.CURRENT_AGREEMENT_NOT_FOUND);
        }
    }
}