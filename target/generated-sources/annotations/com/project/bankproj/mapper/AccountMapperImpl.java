package com.project.bankproj.mapper;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.dto.ClientDto;
import com.project.bankproj.entity.Account;
import com.project.bankproj.entity.Client;
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
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toDto(Account account) {
        if ( account == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String type = null;
        String status = null;
        String balance = null;
        String currency_code = null;
        Timestamp createdAt = null;
        Timestamp updatedAt = null;
        ClientDto client = null;

        if ( account.getId() != null ) {
            id = account.getId().toString();
        }
        name = account.getName();
        if ( account.getType() != null ) {
            type = account.getType().name();
        }
        if ( account.getStatus() != null ) {
            status = account.getStatus().name();
        }
        if ( account.getBalance() != null ) {
            balance = account.getBalance().toString();
        }
        if ( account.getCurrency_code() != null ) {
            currency_code = account.getCurrency_code().name();
        }
        createdAt = account.getCreatedAt();
        updatedAt = account.getUpdatedAt();
        client = clientToClientDto( account.getClient() );

        AccountDto accountDto = new AccountDto( id, name, type, status, balance, currency_code, createdAt, updatedAt, client );

        return accountDto;
    }

    @Override
    public List<AccountDto> toDtoList(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( toDto( account ) );
        }

        return list;
    }

    protected ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        String id = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String address = null;
        String phone = null;

        if ( client.getId() != null ) {
            id = client.getId().toString();
        }
        firstName = client.getFirstName();
        lastName = client.getLastName();
        email = client.getEmail();
        address = client.getAddress();
        phone = client.getPhone();

        ClientDto clientDto = new ClientDto( id, firstName, lastName, email, address, phone );

        return clientDto;
    }
}
