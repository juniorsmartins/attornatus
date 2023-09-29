package io.attornatusapirestjava.adapters.in.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.attornatusapirestjava.adapters.in.request.PessoaDtoResumo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnderecoDtoResponse(

        Long id,

        String logradouro,

        String cep,

        String numero,

        String cidade,

        Boolean statusPrincipal,

        PessoaDtoResumo pessoa
) { }

