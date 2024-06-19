package com.example.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ClienteJaCadastradoException.class)
    public ResponseEntity<?> handleClienteJaCadastradoException(ClienteJaCadastradoException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("message", ex.getMessage()));
    }

    @ExceptionHandler(TelefoneInvalidoException.class)
    public ResponseEntity<?> handleTelefoneInvalidoException(TelefoneInvalidoException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("message", ex.getMessage()));
    }

    @ExceptionHandler(TelefoneJaVinculadoException.class)
    public ResponseEntity<?> handleTelefoneJaVinculadoException(TelefoneJaVinculadoException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("message", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        // Aqui você pode adicionar um log para o erro antes de retornar a resposta
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap("message", "Ocorreu um erro inesperado."));
    }
}
