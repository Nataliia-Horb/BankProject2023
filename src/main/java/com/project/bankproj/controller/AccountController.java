package com.project.bankproj.controller;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/account/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto getAccountById(@PathVariable UUID uuid) {
        return accountService.getAccountById(uuid);
    }

    @GetMapping("/account/find-by-product-id/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> findAccountsWhereProductIdIs(@PathVariable int productId) {
        return accountService.getAccountsWhereProductId(productId);
    }

    @GetMapping("/account")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> getAllAccounts() {
        return accountService.getAccountsList();
    }
}