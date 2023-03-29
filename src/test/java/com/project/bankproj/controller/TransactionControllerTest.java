package com.project.bankproj.controller;

import com.project.bankproj.dto.TransactionDto;
import com.project.bankproj.entity.enums.Currencies;
import com.project.bankproj.service.impl.TransactionServiceImpl;
import com.project.bankproj.util.DtoCreator;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(TransactionController.class)
@DisplayName("TransactionController test class")
public class TransactionControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    TransactionController transactionController;

    @MockBean
    private TransactionServiceImpl transactionService;


    @Test
    void findAllTransactionsWhereAccountCurrencyIs() throws Exception {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        TransactionDto transactionDto = DtoCreator.getTransactionDto();
        transactionDtoList.add(transactionDto);
        Currencies currency = EntityCreator.getAccount().getCurrency_code();
        int currenciesCode = currency.getValue();
        when(transactionService.getTransactionsWhereAccountCurrency(currency)).thenReturn(transactionDtoList);

        mvc.perform(MockMvcRequestBuilders.get("/api/transaction/find-by-currency-code/" + currenciesCode))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].id", is(transactionDto.getId())))
                .andExpect(jsonPath("$[0].type", is(transactionDto.getType())))
                .andExpect(jsonPath("$[0].amount", is(transactionDto.getAmount())))
                .andExpect(jsonPath("$[0].description").value(transactionDto.getDescription()))
                .andExpect(jsonPath("$[0].debitAccountId", is(transactionDto.getDebitAccountId())))
                .andExpect(jsonPath("$[0].creditAccountId", is(transactionDto.getCreditAccountId())));

        verify(transactionService, times(1)).getTransactionsWhereAccountCurrency(currency);
    }
}