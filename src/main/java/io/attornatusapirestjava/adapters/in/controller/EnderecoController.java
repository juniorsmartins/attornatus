package io.attornatusapirestjava.adapters.in.controller;

import io.attornatusapirestjava.adapters.in.request.EnderecoDtoRequest;
import io.attornatusapirestjava.adapters.in.response.EnderecoDtoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/enderecos")
public class EnderecoController {

    private final Logger logger = Logger.getLogger(EnderecoController.class.getName());

    @PutMapping(path = "/{idPessoa}")
    public ResponseEntity<EnderecoDtoResponse> criar(@PathVariable(name = "idPessoa") final Long id,
                                                     @RequestBody @Valid EnderecoDtoRequest dtoRequest) {

        return ResponseEntity
            .ok()
            .body(null);
    }
}

