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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    /**
     * Método para cadastrar um cliente no sistema.
     *
     * @param clienteDTO DTO contendo os dados do cliente a ser salvo.
     * @return DTO do cliente salvo.
     */
    @Transactional
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
        validateCliente(clienteDTO);
        clienteDTO.getTelefones().forEach(this::validateTelefone);
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.getTelefones().forEach(telefone -> telefone.setCliente(cliente));
        Cliente savedCliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(savedCliente);
    }

    /**
     * Valida se o cliente já está cadastrado a partir do nome informado.
     *
     * @param cliente DTO contendo os dados do cliente a ser validado.
     * @throws ClienteJaCadastradoException se o nome do cliente já foi cadastrado.
     */
    public void validateCliente(ClienteDTO cliente) {
        Optional<Cliente> existingCliente = clienteRepository.findByNome(cliente.getNome());
        if (existingCliente.isPresent()) {
            throw new ClienteJaCadastradoException("Cliente já cadastrado");
        }
    }

    /**
     * Valida a duplicidade e o formato do telefone.
     *
     * @param telefone DTO contendo o número do telefone a ser validado.
     * @throws TelefoneInvalidoException se o formato do telefone for inválido.
     * @throws TelefoneJaVinculadoException se o telefone já estiver vinculado a outro cliente.
     */
    public void validateTelefone(TelefoneDTO telefone) {
        String regex = "^\\(?(\\d{2})\\)?\\s?(\\d{4,5}-?\\d{4})$";
        if (!telefone.getNumero().matches(regex)) {
            throw new TelefoneInvalidoException("Formato de telefone inválido");
        }

        Optional<Telefone> existingTelefone = telefoneRepository.findByNumero(telefone.getNumero());
        if (existingTelefone.isPresent()) {
            throw new TelefoneJaVinculadoException("Telefone já está vinculado a outro cliente");
        }
    }
}
