package com.project.bankproj.service.impl;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.exception.AccountNotFoundException;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.mapper.AccountMapper;
import com.project.bankproj.repository.AccountRepository;
import com.project.bankproj.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public List<AccountDto> getAccountList() {
        return accountMapper.toDtoList(accountRepository.findAll());
    }

    @Override
    public AccountDto getAccountById(UUID uuid) {
        return accountMapper.toDto(accountRepository.findAccountById(uuid)
                .orElseThrow(() -> new AccountNotFoundException(ErrorMessage.CURRENT_ACCOUNT_NOT_FOUND)));
    }

    @Override
    public List<AccountDto> getAccountWhereProductId(int productId) {
        return accountMapper.toDtoList(accountRepository.findAccountsWhereProductId(productId));
    }
}