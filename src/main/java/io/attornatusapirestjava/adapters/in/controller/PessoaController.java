package io.attornatusapirestjava.adapters.in.controller;

import io.attornatusapirestjava.adapters.in.mapper.PessoaDtoRequestMapper;
import io.attornatusapirestjava.adapters.in.mapper.PessoaDtoResponseMapper;
import io.attornatusapirestjava.adapters.in.request.PessoaDtoRequest;
import io.attornatusapirestjava.adapters.in.response.PessoaDtoResponse;
import io.attornatusapirestjava.application.ports.in.PessoaConsultarInputPort;
import io.attornatusapirestjava.application.ports.in.PessoaCriarInputPort;
import io.attornatusapirestjava.configs.exception.http_500.FalhaAoConsultarException;
import io.attornatusapirestjava.configs.exception.http_500.FalhaAoCriarException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private PessoaConsultarInputPort pessoaConsultarInputPort;

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

        logger.info("Finalizada requisição para criar uma pessoa.");

        return ResponseEntity
                .created(URI.create("/api/v1/pessoas/" + dtoResponse.getId()))
                .body(dtoResponse);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaDtoResponse> consultar(@PathVariable(name = "id") final Long id) {

        logger.info("Iniciada requisição para consultar uma pessoa.");

        var dtoResponse = Optional.of(id)
                .map(this.pessoaConsultarInputPort::consultar)
                .map(this.pessoaDtoResponseMapper::toPessoaDtoResponse)
                .orElseThrow(() -> new FalhaAoConsultarException("Falha ao consultar uma pessoa."));

        logger.info("Finalizada requisição para consultar uma pessoa.");

        return ResponseEntity
                .ok()
                .body(dtoResponse);
    }
}

