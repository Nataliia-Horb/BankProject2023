package com.project.bankproj.mapper;

import com.project.bankproj.dto.ClientDto;
import com.project.bankproj.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto toDto(Client client);
}