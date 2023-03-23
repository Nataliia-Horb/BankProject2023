package com.project.bankproj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.entity.Agreement;
import com.project.bankproj.service.impl.AgreementServiceImpl;
import com.project.bankproj.util.DtoCreator;
import com.project.bankproj.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(AgreementController.class)
@DisplayName("AgreementController test class")
public class AgreementControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    AgreementController agreementController;

    @MockBean
    private AgreementServiceImpl agreementService;

    @Test
    void create() throws Exception {
        AgreementDto agreementDto = DtoCreator.getAgreementDto();
        Agreement agreement = EntityCreator.getAgreement();

        when(agreementService.save(agreementDto)).thenReturn(agreement);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/agreement")
                        .content(asJsonString(agreementDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.interestRate").value(agreementDto.getInterestRate()))
                .andExpect(jsonPath("$.sum").value(agreementDto.getSum()))
                .andExpect(jsonPath("$.accountId").value(agreementDto.getAccountId()))
                .andExpect(jsonPath("$.productId").value(agreementDto.getProductId()))
                .andExpect(status().isCreated());
        verify(agreementService, times(1)).save(agreementDto);
    }

    public static String asJsonString(AgreementDto agreementDto) {
        try {
            return new ObjectMapper().writeValueAsString(agreementDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void delete() throws Exception {
        Agreement agreement = EntityCreator.getAgreement();
        int agreementId = agreement.getId();
        doNothing().when(agreementService).delete(agreementId);

        mvc.perform(MockMvcRequestBuilders.delete("/api/agreement/" + agreementId))
                .andExpect(status().isOk());
        verify(agreementService, times(1)).delete(agreementId);
    }
}