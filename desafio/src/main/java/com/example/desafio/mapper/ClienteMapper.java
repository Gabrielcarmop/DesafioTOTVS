package com.example.desafio.mapper;

import com.example.desafio.model.Cliente;
import com.example.desafio.model.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(target = "telefones", source = "dto.telefones")
    @Mapping(target = "endereco", source = "dto.endereco")
    Cliente toEntity(ClienteDTO dto);

    @Mapping(target = "telefones", source = "entity.telefones")
    @Mapping(target = "endereco", source = "entity.endereco")
    ClienteDTO toDto(Cliente entity);
}

