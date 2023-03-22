package com.project.bankproj.service;

import com.project.bankproj.dto.AccountDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<AccountDto> getAccountsList();

    AccountDto getAccountById(UUID uuid);

    List<AccountDto> getAccountsWhereProductId(int productId);
}