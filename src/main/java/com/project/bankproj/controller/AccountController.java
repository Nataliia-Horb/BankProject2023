package com.project.bankproj.controller;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@Tag(name = "Account controller", description = "With a controller you can find all accounts or account by any " +
        "valid id oder accounts by any valid product id")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "get Account By Id",
            description = "allows you to find an account by id (uuid)")
    public AccountDto getAccountById(@PathVariable @Parameter(description =
            "enter the UUID value of accountId") UUID uuid) {
        return accountService.getAccountById(uuid);
    }

    @GetMapping("/find-by-product-id/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "find Accounts by Product Id",
            description = "allows you to find accounts by productId (int)")
    public List<AccountDto> findAccountsWhereProductIdIs(@PathVariable @Parameter(description =
            "enter the numerical value of productId") int productId) {
        return accountService.getAccountsWhereProductId(productId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "get all Accounts",
            description = "allows you to get all accounts")
    public List<AccountDto> getAllAccounts() {
        return accountService.getAccountsList();
    }
}