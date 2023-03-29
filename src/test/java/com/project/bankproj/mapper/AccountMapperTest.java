package com.project.bankproj.mapper;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.entity.Account;
import com.project.bankproj.util.DtoCreator;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test class for AccountMapper")
@ExtendWith(MockitoExtension.class)
class AccountMapperTest {
    AccountMapper accountMapper = new AccountMapperImpl();

    @Test
    @DisplayName("When we have correct account then return correct AccountDto")
    void toDto() {
        Account account = EntityCreator.getAccount();
        AccountDto accountDto = DtoCreator.getAccountDto();

        AccountDto currentAccountDto = accountMapper.toDto(account);

        compareDtoWithCurrentDto(accountDto, currentAccountDto);
    }

    @Test
    @DisplayName("When we have correct list of account then return correct list of accountDto")
    void toDtoList() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(EntityCreator.getAccount());
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountDtoList.add(DtoCreator.getAccountDto());

        List<AccountDto> currentAccountDtoList = accountMapper.toDtoList(accountList);

        compareAccountListWithAccountListDto(accountDtoList, currentAccountDtoList);
    }

    private void compareDtoWithCurrentDto(AccountDto accountDto, AccountDto currentAccountDto) {
        assertAll(
                () -> assertEquals(accountDto.getId(), currentAccountDto.getId()),
                () -> assertEquals(accountDto.getName(), currentAccountDto.getName()),
                () -> assertEquals(accountDto.getType(), currentAccountDto.getType()),
                () -> assertEquals(accountDto.getStatus(), currentAccountDto.getStatus()),
                () -> assertEquals(accountDto.getBalance(), currentAccountDto.getBalance()),
                () -> assertEquals(accountDto.getCurrency_code(), currentAccountDto.getCurrency_code()),
                () -> assertEquals(accountDto.getCreatedAt(), currentAccountDto.getCreatedAt()),
                () -> assertEquals(accountDto.getUpdatedAt(), currentAccountDto.getUpdatedAt())
        );
    }

    private void compareAccountListWithAccountListDto(List<AccountDto> accountDtoList, List<AccountDto>
            currentAccountDtoList) {
        assertEquals(accountDtoList.size(), currentAccountDtoList.size());
        for (int i = 0; i < accountDtoList.size(); i++) {
            compareDtoWithCurrentDto(accountDtoList.get(i), currentAccountDtoList.get(i));
        }
    }
}