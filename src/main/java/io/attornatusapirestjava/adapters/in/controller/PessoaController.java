package io.attornatusapirestjava.adapters.in.controller;

import io.attornatusapirestjava.adapters.in.mapper.PessoaDtoRequestMapper;
import io.attornatusapirestjava.adapters.in.mapper.PessoaDtoResponseMapper;
import io.attornatusapirestjava.adapters.in.request.PessoaDtoRequest;
import io.attornatusapirestjava.adapters.in.response.PessoaDtoResponse;
import io.attornatusapirestjava.application.ports.in.PessoaCriarInputPort;
import io.attornatusapirestjava.configs.exception.http500.FalhaAoCriarException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/pessoas")
public class PessoaController {

    private final Logger logger = Logger.getLogger(PessoaController.class.getName());

    @Autowired
    private PessoaCriarInputPort pessoaCriarInputPort;

    @Autowired
    private PessoaDtoRequestMapper pessoaDtoRequestMapper;

    @Autowired
    private PessoaDtoResponseMapper pessoaDtoResponseMapper;

    @PostMapping
    public ResponseEntity<PessoaDtoResponse> criar(@RequestBody @Valid PessoaDtoRequest dtoRequest) {

        logger.info("Iniciado requisição para criar uma pessoa.");

        var dtoResponse = Optional.of(dtoRequest)
                .map(this.pessoaDtoRequestMapper::toPessoa)
                .map(this.pessoaCriarInputPort::criar)
                .map(this.pessoaDtoResponseMapper::toPessoaDtoResponse)
                .orElseThrow(() -> new FalhaAoCriarException("Falha ao criar uma pessoa."));

        logger.info("Concluída requisição para criar uma pessoa.");

        return ResponseEntity
                .created(URI.create("/api/v1/pessoas/" + dtoResponse.getId()))
                .body(dtoResponse);
    }
}

