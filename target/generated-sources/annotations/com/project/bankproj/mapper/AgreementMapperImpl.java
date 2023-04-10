package com.project.bankproj.mapper;

import com.project.bankproj.dto.AccountDto;
import com.project.bankproj.dto.AgreementDto;
import com.project.bankproj.dto.AgreementResponseDto;
import com.project.bankproj.dto.ClientDto;
import com.project.bankproj.dto.ManagerDto;
import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Account;
import com.project.bankproj.entity.Agreement;
import com.project.bankproj.entity.Client;
import com.project.bankproj.entity.Manager;
import com.project.bankproj.entity.Product;
import com.project.bankproj.entity.enums.AgreementStatus;
import com.project.bankproj.repository.AccountRepository;
import com.project.bankproj.repository.ProductRepository;
import java.sql.Timestamp;
import java.util.UUID;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T23:54:10+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class AgreementMapperImpl implements AgreementMapper {

    @Override
    public AgreementDto toDto(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }

        AgreementDto.AgreementDtoBuilder agreementDto = AgreementDto.builder();

        agreementDto.productId( agreementProductId( agreement ) );
        UUID id1 = agreementAccountId( agreement );
        if ( id1 != null ) {
            agreementDto.accountId( id1.toString() );
        }
        agreementDto.interestRate( agreement.getInterestRate() );
        agreementDto.sum( agreement.getSum() );

        return agreementDto.build();
    }

    @Override
    public AgreementResponseDto toResponseDto(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }

        String id = null;
        String interestRate = null;
        String status = null;
        String sum = null;
        Timestamp createdAt = null;
        Timestamp updatedAt = null;
        AccountDto account = null;
        ProductDto product = null;

        id = String.valueOf( agreement.getId() );
        if ( agreement.getInterestRate() != null ) {
            interestRate = agreement.getInterestRate().toString();
        }
        if ( agreement.getStatus() != null ) {
            status = agreement.getStatus().name();
        }
        if ( agreement.getSum() != null ) {
            sum = agreement.getSum().toString();
        }
        createdAt = agreement.getCreatedAt();
        updatedAt = agreement.getUpdatedAt();
        account = accountToAccountDto( agreement.getAccount() );
        product = productToProductDto( agreement.getProduct() );

        AgreementResponseDto agreementResponseDto = new AgreementResponseDto( id, interestRate, status, sum, createdAt, updatedAt, account, product );

        return agreementResponseDto;
    }

    @Override
    public Agreement toEntity(AgreementDto agreement, ProductRepository productRepository, AccountRepository accountRepository) {
        if ( agreement == null && productRepository == null && accountRepository == null ) {
            return null;
        }

        Agreement agreement1 = new Agreement();

        if ( agreement != null ) {
            agreement1.setInterestRate( agreement.getInterestRate() );
            agreement1.setSum( agreement.getSum() );
        }
        agreement1.setStatus( AgreementStatus.ACTIVE );
        agreement1.setAccount( checkAccountId(agreement, accountRepository) );
        agreement1.setProduct( checkProductId(agreement, productRepository) );

        return agreement1;
    }

    private int agreementProductId(Agreement agreement) {
        if ( agreement == null ) {
            return 0;
        }
        Product product = agreement.getProduct();
        if ( product == null ) {
            return 0;
        }
        int id = product.getId();
        return id;
    }

    private UUID agreementAccountId(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }
        Account account = agreement.getAccount();
        if ( account == null ) {
            return null;
        }
        UUID id = account.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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

    protected AccountDto accountToAccountDto(Account account) {
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

    protected ManagerDto managerToManagerDto(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        String id = null;
        String firstName = null;
        String lastName = null;
        String status = null;

        id = String.valueOf( manager.getId() );
        firstName = manager.getFirstName();
        lastName = manager.getLastName();
        if ( manager.getStatus() != null ) {
            status = manager.getStatus().name();
        }

        ManagerDto managerDto = new ManagerDto( id, firstName, lastName, status );

        return managerDto;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String status = null;
        String currency_code = null;
        String interestRate = null;
        String limit = null;
        Timestamp createdAt = null;
        Timestamp updatedAt = null;
        ManagerDto manager = null;

        id = String.valueOf( product.getId() );
        name = product.getName();
        if ( product.getStatus() != null ) {
            status = product.getStatus().name();
        }
        if ( product.getCurrency_code() != null ) {
            currency_code = product.getCurrency_code().name();
        }
        if ( product.getInterestRate() != null ) {
            interestRate = product.getInterestRate().toString();
        }
        limit = String.valueOf( product.getLimit() );
        createdAt = product.getCreatedAt();
        updatedAt = product.getUpdatedAt();
        manager = managerToManagerDto( product.getManager() );

        ProductDto productDto = new ProductDto( id, name, status, currency_code, interestRate, limit, createdAt, updatedAt, manager );

        return productDto;
    }
}
