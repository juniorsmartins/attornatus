package io.attornatusapirestjava.adapters.in.request;

public record PessoaEditarDtoRequest(

        Long id,

        String nome,

        String dataNascimento
) { }

