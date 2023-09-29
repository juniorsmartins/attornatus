package io.attornatusapirestjava.adapters.in.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PessoaDtoResponse(

        Long id,

        String nome,

        String dataNascimento,

        Set<EnderecoDtoResponse> enderecos
) { }

