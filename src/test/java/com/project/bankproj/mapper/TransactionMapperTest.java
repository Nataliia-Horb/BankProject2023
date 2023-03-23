package com.project.bankproj.mapper;

import com.project.bankproj.dto.TransactionDto;
import com.project.bankproj.entity.Transaction;
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

@DisplayName("Test class for TransactionMapper")
@ExtendWith(MockitoExtension.class)
public class TransactionMapperTest {

    TransactionMapper transactionMapper = new TransactionMapperImpl();

    @Test
    @DisplayName("When we have correct transaction then return correct TransactionDto")
    void toDto() {
        Transaction transaction = EntityCreator.getTransaction();
        TransactionDto transactionDto = DtoCreator.getTransactionDto();

        TransactionDto currentTransactionDto = transactionMapper.toDto(transaction);

        compareDtoWithCurrentDto(transactionDto, currentTransactionDto);
    }

    @Test
    @DisplayName("When we have correct list of transaction then return correct list of transactionDto")
    void toDtoList() {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(EntityCreator.getTransaction());
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        transactionDtoList.add(DtoCreator.getTransactionDto());

        List<TransactionDto> currentTransactionDtoList = transactionMapper.toDtoList(transactionList);

        compareTransactionListWithTransactionListDto(transactionDtoList, currentTransactionDtoList);
    }

    private void compareDtoWithCurrentDto(TransactionDto transactionDto, TransactionDto currentTransactionDto) {
        assertAll(
                () -> assertEquals(transactionDto.getId(), currentTransactionDto.getId()),
                () -> assertEquals(transactionDto.getType(), currentTransactionDto.getType()),
                () -> assertEquals(transactionDto.getAmount(), currentTransactionDto.getAmount()),
                () -> assertEquals(transactionDto.getDescription(), currentTransactionDto.getDescription()),
                () -> assertEquals(transactionDto.getType(), currentTransactionDto.getType()),
                () -> assertEquals(transactionDto.getAmount(), currentTransactionDto.getAmount()),
                () -> assertEquals(transactionDto.getCreatedAt(), currentTransactionDto.getCreatedAt()),
                () -> assertEquals(transactionDto.getDebitAccountId(), currentTransactionDto.getDebitAccountId()),
                () -> assertEquals(transactionDto.getCreditAccountId(), currentTransactionDto.getCreditAccountId())
        );
    }

    private void compareTransactionListWithTransactionListDto(List<TransactionDto> transactionDtoList, List<TransactionDto>
            currentTransactionDtoList) {
        assertEquals(transactionDtoList.size(), currentTransactionDtoList.size());
        for (int i = 0; i < transactionDtoList.size(); i++) {
            compareDtoWithCurrentDto(transactionDtoList.get(i), currentTransactionDtoList.get(i));
        }
    }
}