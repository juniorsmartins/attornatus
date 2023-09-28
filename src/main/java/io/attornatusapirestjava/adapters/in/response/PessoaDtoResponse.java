package io.attornatusapirestjava.adapters.in.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PessoaDtoResponse(

        Long id,

        String nome,

        String dataNascimento
) { }

