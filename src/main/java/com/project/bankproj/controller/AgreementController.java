package com.project.bankproj.controller;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.dto.AgreementResponseDto;
import com.project.bankproj.service.AgreementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agreement")
@RequiredArgsConstructor
@Tag(name = "Agreement controller", description = "With a controller you can create new agreement" +
        " or delete agreement by id")
public class AgreementController {
    private final AgreementService agreementService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "create new Agreement",
            description = "allows you to create new agreement")
    public AgreementResponseDto create(@Valid @RequestBody @Parameter(description =
            "enter the following data for entity consciousness " +
                    "'interestRate':(double),'sum': (double), 'accountId': (uuid), 'productId': (int)")
                                       AgreementDto newAgreement) {
        return agreementService.save(newAgreement);
    }

    @DeleteMapping(path = "/{agreementId}")
    @ResponseStatus(HttpStatus.OK)
    @SecurityRequirement(name = "JWT")
    @Operation(
            summary = "delete Agreement by Id",
            description = "allows you to delete an agreement with id (int)")
    public void delete(@PathVariable @Parameter(description =
            "enter the numerical value of agreementId") int agreementId) {
        agreementService.delete(agreementId);
    }
}