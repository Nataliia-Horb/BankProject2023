package com.project.bankproj.controller;

import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.service.AgreementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agreement")
@RequiredArgsConstructor
public class AgreementController {
    private final AgreementService agreementService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgreementDto> create(@Valid @RequestBody AgreementDto newAgreement) {
        if (newAgreement == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            agreementService.save(newAgreement);
            return new ResponseEntity<>(newAgreement, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(path = "/{agreementId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("agreementId") int agreementId) {
        agreementService.delete(agreementId);
    }
}