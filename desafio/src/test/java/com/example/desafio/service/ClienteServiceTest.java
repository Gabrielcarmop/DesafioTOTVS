package com.example.desafio.service;

import com.example.desafio.exception.ClienteJaCadastradoException;
import com.example.desafio.exception.TelefoneInvalidoException;
import com.example.desafio.exception.TelefoneJaVinculadoException;
import com.example.desafio.mapper.ClienteMapper;
import com.example.desafio.model.Cliente;
import com.example.desafio.model.Telefone;
import com.example.desafio.model.dto.ClienteDTO;
import com.example.desafio.model.dto.TelefoneDTO;
import com.example.desafio.repository.ClienteRepository;
import com.example.desafio.repository.TelefoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {
    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private TelefoneRepository telefoneRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void Save_ClienteJaCadastrado() {

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("UsuarioTeste");

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("UsuarioTeste");

        when(clienteRepository.findByNome(anyString())).thenReturn(Optional.of(cliente));
        assertThrows(ClienteJaCadastradoException.class, () -> clienteService.saveCliente(clienteDTO));
        verify(clienteRepository, times(1)).findByNome(clienteDTO.getNome());
    }

    @Test
    public void Validate_TelefoneInvalido() {

        TelefoneDTO telefoneDTO = new TelefoneDTO();
        telefoneDTO.setNumero("12345");

        assertThrows(TelefoneInvalidoException.class, () -> clienteService.validateTelefone(telefoneDTO));
    }

    @Test
    public void testValidate_TelefoneJaVinculado() {
        TelefoneDTO telefoneDTO = new TelefoneDTO();
        telefoneDTO.setNumero("99999999999");

        Telefone telefone = new Telefone();
        telefone.setId(1L);
        telefone.setNumero("99999999999");

        when(telefoneRepository.findByNumero(anyString())).thenReturn(Optional.of(telefone));
        assertThrows(TelefoneJaVinculadoException.class, () -> clienteService.validateTelefone(telefoneDTO));
        verify(telefoneRepository, times(1)).findByNumero(telefoneDTO.getNumero());
    }
}
