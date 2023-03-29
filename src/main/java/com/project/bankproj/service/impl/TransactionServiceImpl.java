package com.project.bankproj.service.impl;

import com.project.bankproj.dto.TransactionDto;
import com.project.bankproj.entity.enums.Currencies;
import com.project.bankproj.mapper.TransactionMapper;
import com.project.bankproj.repository.TransactionRepository;
import com.project.bankproj.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<TransactionDto> getTransactionsWhereAccountCurrency(Currencies currency_code) {
        log.info("Get transactions where currency_code {}", currency_code);
        return transactionMapper.toDtoList(transactionRepository.findTransactionsWhereCurrencies(currency_code));
    }
}