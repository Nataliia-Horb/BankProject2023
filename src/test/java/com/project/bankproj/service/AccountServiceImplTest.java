package com.project.bankproj.service;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.entity.Account;
import com.project.bankproj.exception.AccountNotFoundException;
import com.project.bankproj.exception.ErrorMessage;
import com.project.bankproj.mapper.AccountMapper;
import com.project.bankproj.repository.AccountRepository;
import com.project.bankproj.service.impl.AccountServiceImpl;
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
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("Test class for AccountServiceImpl")
@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
    @Mock
    AccountRepository repository;
    @Mock
    AccountMapper mapper;
    @InjectMocks
    AccountServiceImpl accountService;


    @Test
    void getAccountById() {
        Account account = EntityCreator.getAccount();
        AccountDto accountDto = DtoCreator.getAccountDto();
        when(repository.findAccountById(account.getId())).thenReturn(Optional.of(account));
        when(mapper.toDto(account)).thenReturn(accountDto);

        AccountDto currentAccountDto = accountService.getAccountById(account.getId());

        assertEquals(accountDto, currentAccountDto);
        verify(repository, times(1)).findAccountById(account.getId());
    }

    @Test
    void getAccountList() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(EntityCreator.getAccount());
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountDtoList.add(DtoCreator.getAccountDto());
        when(repository.findAll()).thenReturn(accounts);
        when(mapper.toDtoList(accounts)).thenReturn(accountDtoList);

        List<AccountDto> currentAccountDtoList = accountService.getAccountsList();

        assertEquals(accountDtoList, currentAccountDtoList);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getAccountWhereProductId() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(EntityCreator.getAccount());
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountDtoList.add(DtoCreator.getAccountDto());
        int productId = EntityCreator.getProduct().getId();
        when(repository.findAccountsWhereProductId(productId)).thenReturn(accounts);
        when(mapper.toDtoList(accounts)).thenReturn(accountDtoList);

        List<AccountDto> currentAccountDtoList = accountService.getAccountsWhereProductId(EntityCreator.getProduct().getId());

        assertEquals(accountDtoList, currentAccountDtoList);
        verify(repository, times(1)).findAccountsWhereProductId(productId);
    }


    @Test
    void throwExceptionIfNotFindAccountId() {
        Exception exception = assertThrows(AccountNotFoundException.class, () ->
                accountService.getAccountById(UUID.randomUUID()));
        assertEquals(ErrorMessage.CURRENT_ACCOUNT_NOT_FOUND, exception.getMessage());
    }

    @Test
    void throwExceptionIfAccountListIsEmpty() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        Exception exception = assertThrows(AccountNotFoundException.class, () -> accountService.getAccountsList());
        assertEquals(ErrorMessage.ACCOUNTS_NOT_FOUND, exception.getMessage());
    }
}