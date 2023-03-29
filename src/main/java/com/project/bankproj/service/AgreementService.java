package com.project.bankproj.service;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.entity.Agreement;

public interface AgreementService {

    Agreement save(AgreementDto newAgreement);

    void delete(int agreementId);
}