package com.project.bankproj.controller;

import com.project.bankproj.dto.TransactionDto;
import com.project.bankproj.entity.enums.Currencies;
import com.project.bankproj.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
@Tag(name = "Transaction controller", description = "With a controller you can find transactions with any valid" +
        " currency_code. Checking the currency code is carried out on debit and credit accounts")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/find-by-currency-code/{currency_code}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "find Transactions by Currency code",
            description = "allows you to find transactions by currency code (int)")
    public List<TransactionDto> findAllTransactionsWhereAccountCurrencyIs(
            @PathVariable("currency_code") @Parameter(description = "enter the numerical value of the currency code: " +
                    " 0-EUR, 1-USD, 2-UAH, 3-RUB") int currency_code) {
            return transactionService.getTransactionsWhereAccountCurrency(Currencies.getCurrency(currency_code));
    }
}