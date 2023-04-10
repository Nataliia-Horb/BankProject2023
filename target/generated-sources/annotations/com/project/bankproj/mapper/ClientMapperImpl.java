package com.project.bankproj.mapper;

import com.project.bankproj.dto.ClientDto;
import com.project.bankproj.entity.Client;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T23:54:10+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDto(Client client) {
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
