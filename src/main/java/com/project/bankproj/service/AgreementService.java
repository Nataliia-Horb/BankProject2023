package com.project.bankproj.service;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.dto.AgreementResponseDto;

public interface AgreementService {

    AgreementResponseDto save(AgreementDto newAgreement);

    void delete(int agreementId);
}