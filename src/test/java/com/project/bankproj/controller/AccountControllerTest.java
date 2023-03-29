package com.project.bankproj.controller;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.entity.Product;
import com.project.bankproj.service.impl.AccountServiceImpl;
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
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(AccountController.class)
@DisplayName("AccountController test class")
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    AccountController accountController;

    @MockBean
    private AccountServiceImpl accountService;

    @Test
    void getAllAccounts() throws Exception {
        List<AccountDto> accountDtoList = new ArrayList<>();
        AccountDto accountDto = DtoCreator.getAccountDto();
        accountDtoList.add(accountDto);
        when(accountService.getAccountsList()).thenReturn(accountDtoList);

        mvc.perform(MockMvcRequestBuilders.get("/api/account").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(accountDto.getId())))
                .andExpect(jsonPath("$[0].name", is(accountDto.getName())))
                .andExpect(jsonPath("$[0].status", is(accountDto.getStatus())))
                .andExpect(jsonPath("$[0].balance").value(accountDto.getBalance()))
                .andExpect(jsonPath("$[0].currency_code", is(accountDto.getCurrency_code())));
        verify(accountService, times(1)).getAccountsList();
    }

    @Test
    void getAccountById() throws Exception {
        AccountDto accountDto = DtoCreator.getAccountDto();
        UUID accountId = UUID.fromString(accountDto.getId());
        when(accountService.getAccountById(accountId)).thenReturn(accountDto);

        mvc.perform(MockMvcRequestBuilders.get("/api/account/" + accountId))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id", is(accountDto.getId())))
                .andExpect(jsonPath("$.name", is(accountDto.getName())))
                .andExpect(jsonPath("$.status", is(accountDto.getStatus())))
                .andExpect(jsonPath("$.balance").value(accountDto.getBalance()))
                .andExpect(jsonPath("$.currency_code", is(accountDto.getCurrency_code())));

        verify(accountService, times(1)).getAccountById(accountId);
    }

    @Test
    void findAccountsWhereProductIdIs() throws Exception {
        List<AccountDto> accountDtoList = new ArrayList<>();
        AccountDto accountDto = DtoCreator.getAccountDto();
        accountDtoList.add(accountDto);
        Product product = EntityCreator.getProduct();
        int productId = product.getId();
        when(accountService.getAccountsWhereProductId(productId)).thenReturn(accountDtoList);

        mvc.perform(MockMvcRequestBuilders.get("/api/account/find-by-product-id/" + productId))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].id", is(accountDto.getId())))
                .andExpect(jsonPath("$[0].name", is(accountDto.getName())))
                .andExpect(jsonPath("$[0].status", is(accountDto.getStatus())))
                .andExpect(jsonPath("$[0].balance").value(accountDto.getBalance()))
                .andExpect(jsonPath("$[0].currency_code", is(accountDto.getCurrency_code())));

        verify(accountService, times(1)).getAccountsWhereProductId(productId);
    }
}