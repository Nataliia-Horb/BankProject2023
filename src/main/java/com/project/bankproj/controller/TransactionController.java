package com.project.bankproj.controller;

import com.project.bankproj.dto.TransactionDto;
import com.project.bankproj.entity.enums.Currencies;
import com.project.bankproj.exception.ElementNotFoundException;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/find-by-currency-code/{currency_code}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TransactionDto> findAllTransactionsWhereAccountCurrencyIs(@PathVariable int currency_code) {
        Currencies currency = Currencies.getCurrency(currency_code);
        if (currency == null) {
            throw new ElementNotFoundException(ErrorMessage.CURRENT_ELEMENT_NOT_FOUND);
        } else {
            return transactionService.getTransactionsWhereAccountCurrency(Currencies.getCurrency(currency_code));
        }
    }
}