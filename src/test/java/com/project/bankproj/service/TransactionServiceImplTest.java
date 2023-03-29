package com.project.bankproj.service;

import com.project.bankproj.dto.TransactionDto;
import com.project.bankproj.entity.Transaction;
import com.project.bankproj.entity.enums.Currencies;
import com.project.bankproj.mapper.TransactionMapper;
import com.project.bankproj.repository.TransactionRepository;
import com.project.bankproj.service.impl.TransactionServiceImpl;
import com.project.bankproj.util.DtoCreator;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("Test class for TransactionServiceImpl")
@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

    @Mock
    TransactionRepository repository;
    @Mock
    TransactionMapper mapper;
    @InjectMocks
    TransactionServiceImpl transactionService;


    @Test
    void getTransactionsWhereAccountCurrency() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(EntityCreator.getTransaction());
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        transactionDtoList.add(DtoCreator.getTransactionDto());
        Currencies currency = EntityCreator.getAccount().getCurrency_code();
        when(repository.findTransactionsWhereCurrencies(currency)).thenReturn(transactions);
        when(mapper.toDtoList(transactions)).thenReturn(transactionDtoList);

        List<TransactionDto> currentTransactionDtoList = transactionService.
                getTransactionsWhereAccountCurrency(currency);

        assertEquals(transactionDtoList, currentTransactionDtoList);
        verify(repository, times(1)).findTransactionsWhereCurrencies(currency);
    }
}