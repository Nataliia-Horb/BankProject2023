package com.project.bankproj.mapper;

import com.project.bankproj.dto.ManagerDto;
import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Manager;
import com.project.bankproj.entity.Product;
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
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
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

    @Override
    public List<ProductDto> toDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( toDto( product ) );
        }

        return list;
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
}
