package com.project.bankproj.mapper;

import com.project.bankproj.dto.ManagerDto;
import com.project.bankproj.entity.Manager;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T23:54:10+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ManagerMapperImpl implements ManagerMapper {

    @Override
    public ManagerDto toDto(Manager manager) {
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
}
