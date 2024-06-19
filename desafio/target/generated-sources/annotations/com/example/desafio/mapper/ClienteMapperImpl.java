package com.example.desafio.mapper;

import com.example.desafio.model.Cliente;
import com.example.desafio.model.Endereco;
import com.example.desafio.model.Telefone;
import com.example.desafio.model.dto.ClienteDTO;
import com.example.desafio.model.dto.EnderecoDTO;
import com.example.desafio.model.dto.TelefoneDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T23:19:33-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setTelefones( telefoneDTOListToTelefoneList( dto.getTelefones() ) );
        cliente.setEndereco( enderecoDTOToEndereco( dto.getEndereco() ) );
        cliente.setNome( dto.getNome() );

        return cliente;
    }

    @Override
    public ClienteDTO toDto(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setTelefones( telefoneListToTelefoneDTOList( entity.getTelefones() ) );
        clienteDTO.setEndereco( enderecoToEnderecoDTO( entity.getEndereco() ) );
        clienteDTO.setNome( entity.getNome() );

        return clienteDTO;
    }

    protected Telefone telefoneDTOToTelefone(TelefoneDTO telefoneDTO) {
        if ( telefoneDTO == null ) {
            return null;
        }

        Telefone telefone = new Telefone();

        telefone.setNumero( telefoneDTO.getNumero() );

        return telefone;
    }

    protected List<Telefone> telefoneDTOListToTelefoneList(List<TelefoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Telefone> list1 = new ArrayList<Telefone>( list.size() );
        for ( TelefoneDTO telefoneDTO : list ) {
            list1.add( telefoneDTOToTelefone( telefoneDTO ) );
        }

        return list1;
    }

    protected Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setRua( enderecoDTO.getRua() );
        endereco.setCidade( enderecoDTO.getCidade() );
        endereco.setBairro( enderecoDTO.getBairro() );
        endereco.setNumero( enderecoDTO.getNumero() );

        return endereco;
    }

    protected TelefoneDTO telefoneToTelefoneDTO(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        TelefoneDTO telefoneDTO = new TelefoneDTO();

        telefoneDTO.setNumero( telefone.getNumero() );

        return telefoneDTO;
    }

    protected List<TelefoneDTO> telefoneListToTelefoneDTOList(List<Telefone> list) {
        if ( list == null ) {
            return null;
        }

        List<TelefoneDTO> list1 = new ArrayList<TelefoneDTO>( list.size() );
        for ( Telefone telefone : list ) {
            list1.add( telefoneToTelefoneDTO( telefone ) );
        }

        return list1;
    }

    protected EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setRua( endereco.getRua() );
        enderecoDTO.setCidade( endereco.getCidade() );
        enderecoDTO.setBairro( endereco.getBairro() );
        enderecoDTO.setNumero( endereco.getNumero() );

        return enderecoDTO;
    }
}
