package com.project.bankproj.mapper;

import com.project.bankproj.dto.TransactionDto;
import com.project.bankproj.entity.Transaction;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T23:54:10+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionDto toDto(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        String debitAccountId = null;
        String creditAccountId = null;
        String id = null;
        String type = null;
        String amount = null;
        String description = null;
        Timestamp createdAt = null;

        debitAccountId = getAccountId( transaction.getDebitAccountId() );
        creditAccountId = getAccountId( transaction.getCreditAccountId() );
        if ( transaction.getId() != null ) {
            id = transaction.getId().toString();
        }
        if ( transaction.getType() != null ) {
            type = transaction.getType().name();
        }
        if ( transaction.getAmount() != null ) {
            amount = transaction.getAmount().toString();
        }
        description = transaction.getDescription();
        createdAt = transaction.getCreatedAt();

        TransactionDto transactionDto = new TransactionDto( id, type, amount, description, createdAt, debitAccountId, creditAccountId );

        return transactionDto;
    }

    @Override
    public List<TransactionDto> toDtoList(List<Transaction> transactions) {
        if ( transactions == null ) {
            return null;
        }

        List<TransactionDto> list = new ArrayList<TransactionDto>( transactions.size() );
        for ( Transaction transaction : transactions ) {
            list.add( toDto( transaction ) );
        }

        return list;
    }
}
