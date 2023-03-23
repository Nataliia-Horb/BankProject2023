package com.project.bankproj.service.impl;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.entity.Account;
import com.project.bankproj.exception.AccountNotFoundException;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.mapper.AccountMapper;
import com.project.bankproj.repository.AccountRepository;
import com.project.bankproj.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public List<AccountDto> getAccountsList() {
        log.info("Get all accounts");
        List<Account> list = accountRepository.findAll();
        return accountMapper.toDtoList(list);
    }

    @Override
    public AccountDto getAccountById(UUID uuid) {
        log.info("Get account with id {}", uuid);
        return accountMapper.toDto(accountRepository.findAccountById(uuid)
                .orElseThrow(() -> new AccountNotFoundException(ErrorMessage.CURRENT_ACCOUNT_NOT_FOUND)));
    }

    @Override
    public List<AccountDto> getAccountsWhereProductId(int productId) {
        log.info("Get account where ProductId {}", productId);
        return accountMapper.toDtoList(accountRepository.findAccountsWhereProductId(productId));
    }
}