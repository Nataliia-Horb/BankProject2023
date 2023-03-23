package com.project.bankproj.mapper;

import com.project.bankproj.dto.TransactionDto;

import com.project.bankproj.entity.Account;
import com.project.bankproj.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {


    @Mapping(source = "debitAccountId", target = "debitAccountId", qualifiedByName = "string_of_account")
    @Mapping(source = "creditAccountId", target = "creditAccountId", qualifiedByName = "string_of_account")
    TransactionDto toDto(Transaction transaction);

    List<TransactionDto> toDtoList(List<Transaction> transactions);

    @Named("string_of_account")
    default String getAccountId(Account account) {
        return account.getId().toString();
    }
}