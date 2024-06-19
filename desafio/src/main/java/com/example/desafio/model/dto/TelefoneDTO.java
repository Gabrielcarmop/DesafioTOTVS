package com.example.desafio.model.dto;
import jakarta.validation.constraints.NotBlank;

public class TelefoneDTO {
    @NotBlank(message = "O número do telefone não pode ser nulo")
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
