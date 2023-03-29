package com.project.bankproj.service;

import com.project.bankproj.dto.TransactionDto;
import com.project.bankproj.entity.enums.Currencies;

import java.util.List;

public interface TransactionService {
    List<TransactionDto> getTransactionsWhereAccountCurrency(Currencies currency_code);
}