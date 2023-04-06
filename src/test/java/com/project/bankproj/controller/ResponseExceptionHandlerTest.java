package com.project.bankproj.controller;

import com.project.bankproj.exception.*;
import com.project.bankproj.service.impl.AccountServiceImpl;
import com.project.bankproj.service.impl.AgreementServiceImpl;
import com.project.bankproj.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest({ProductController.class, AgreementController.class, AccountController.class})
@DisplayName("ResponseExceptionHandler test class")
public class ResponseExceptionHandlerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AgreementServiceImpl agreementService;

    @MockBean
    private AccountServiceImpl accountService;

    @MockBean
    private ProductServiceImpl productService;

    @Autowired
    ResponseExceptionHandler responseExceptionHandler;

    @Test
    void handleProductNotFoundException() throws Exception {
        int someId = 1;
        Exception exception = new ProductNotFoundException(ErrorMessage.CURRENT_PRODUCT_NOT_FOUND);
        doThrow(exception).when(productService).getProductById(someId);

        mvc.perform(MockMvcRequestBuilders.get("/api/product/" + someId).accept(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(jsonPath("$.message").value(ErrorMessage.CURRENT_PRODUCT_NOT_FOUND))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.PRODUCT_NOT_FOUND));
        verify(productService, times(1)).getProductById(someId);
    }

    @Test
    void handleAccountNotFoundException() throws Exception {
        UUID someId = UUID.fromString("72c98cd3-b1d5-11ed-8545-08979887bb18");
        Exception exception = new AccountNotFoundException(ErrorMessage.CURRENT_ACCOUNT_NOT_FOUND);
        doThrow(exception).when(accountService).getAccountById(someId);

        mvc.perform(MockMvcRequestBuilders.get("/api/account/" + someId).accept(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(jsonPath("$.message").value(ErrorMessage.CURRENT_ACCOUNT_NOT_FOUND))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.ACCOUNT_NOT_FOUND));
        verify(accountService, times(1)).getAccountById(someId);
    }

    @Test
    void handleAgreementNotFoundException() throws Exception {
        int someId = 1;
        Exception exception = new AgreementNotFoundException(ErrorMessage.CURRENT_AGREEMENT_NOT_FOUND);
        doThrow(exception).when(agreementService).delete(someId);

        mvc.perform(MockMvcRequestBuilders.delete("/api/agreement/" + someId).accept(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print())
                .andExpect(jsonPath("$.message").value(ErrorMessage.CURRENT_AGREEMENT_NOT_FOUND))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.AGREEMENT_NOT_FOUND));
        verify(agreementService, times(1)).delete(someId);
    }
}