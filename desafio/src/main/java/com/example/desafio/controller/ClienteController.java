package com.example.desafio.controller;

import com.example.desafio.model.dto.ClienteDTO;
import com.example.desafio.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Endpoint para cadastrar um novo cliente.
     *
     * @param clienteDTO DTO contendo os dados do cliente a ser criado.
     * @return ResponseEntity com o DTO do cliente criado e status HTTP 201 se criado com sucesso.
     */
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO savedClienteDTO = clienteService.saveCliente(clienteDTO);
        return new ResponseEntity<>(savedClienteDTO, HttpStatus.CREATED);
    }
}
