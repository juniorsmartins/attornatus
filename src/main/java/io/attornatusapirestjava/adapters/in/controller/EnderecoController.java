package io.attornatusapirestjava.adapters.in.controller;

import io.attornatusapirestjava.adapters.in.mapper.EnderecoDtoRequestMapper;
import io.attornatusapirestjava.adapters.in.mapper.EnderecoDtoResponseMapper;
import io.attornatusapirestjava.adapters.in.request.EnderecoDtoRequest;
import io.attornatusapirestjava.adapters.in.response.EnderecoDtoResponse;
import io.attornatusapirestjava.application.ports.in.EnderecoCriarInputPort;
import io.attornatusapirestjava.application.ports.in.EnderecoListarInputPort;
import io.attornatusapirestjava.configs.exception.http_500.FalhaAoCriarEnderecoException;
import io.attornatusapirestjava.configs.exception.http_500.FalhaAoListarEnderecosException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/enderecos")
public class EnderecoController {

    private final Logger logger = Logger.getLogger(EnderecoController.class.getName());

    @Autowired
    private EnderecoCriarInputPort enderecoCriarInputPort;

    @Autowired
    private EnderecoListarInputPort enderecoListarInputPort;

    @Autowired
    private EnderecoDtoRequestMapper enderecoDtoRequestMapper;

    @Autowired
    private EnderecoDtoResponseMapper enderecoDtoResponseMapper;

    @PutMapping(path = "/{idPessoa}")
    public ResponseEntity<EnderecoDtoResponse> criar(@PathVariable(name = "idPessoa") final Long id,
                                                     @RequestBody @Valid EnderecoDtoRequest dtoRequest) {

        logger.info("Controller recebe requisição para criar um endereço.");

        var dtoResponse = Optional.of(dtoRequest)
                .map(this.enderecoDtoRequestMapper::toEndereco)
                .map(address -> this.enderecoCriarInputPort.criar(id, address))
                .map(this.enderecoDtoResponseMapper::toEnderecoDtoResponse)
                .orElseThrow(FalhaAoCriarEnderecoException::new);

        logger.info("Controller concretiza requisição para criar um endereço.");

        return ResponseEntity
            .ok()
            .body(dtoResponse);
    }

    @GetMapping(path = "/{idPessoa}")
    public ResponseEntity<Set<EnderecoDtoResponse>> listarPorPessoa(@PathVariable(name = "idPessoa") final Long id) {

        logger.info("Controller recebe requisição para listar endereços por pessoa.");

        var response = Optional.of(id)
            .map(this.enderecoListarInputPort::listarPorPessoa)
            .map(this.enderecoDtoResponseMapper::toSetEnderecosDtoResponse)
            .orElseThrow(FalhaAoListarEnderecosException::new);

        logger.info("Controller concretiza requisição para listar endereços por pessoa.");

        return ResponseEntity
            .ok()
            .body(response);
    }
}

