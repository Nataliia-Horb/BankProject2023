package com.project.bankproj.service;

import com.project.bankproj.dto.AgreementDto;

public interface AgreementService {

    void save(AgreementDto newAgreement);

    AgreementDto delete(int agreementId);
}