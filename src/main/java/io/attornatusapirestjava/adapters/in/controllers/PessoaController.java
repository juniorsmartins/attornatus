package io.attornatusapirestjava.adapters.in.controllers;

import io.attornatusapirestjava.adapters.in.request.PessoaDtoRequest;
import io.attornatusapirestjava.adapters.in.response.PessoaDtoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/pessoas")
public class PessoaController {

    private final Logger logger = Logger.getLogger(PessoaController.class.getName());

    @PostMapping
    public ResponseEntity<PessoaDtoResponse> criar(@RequestBody @Valid PessoaDtoRequest dtoRequest) {

        logger.info("Requisição para criar uma pessoa.");
        System.out.println(dtoRequest);


        return ResponseEntity
                .created(URI.create("/api/v1/pessoas/" + 1L))
                .body(null);
    }
}

