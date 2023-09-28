package io.attornatusapirestjava.adapters.in.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record EnderecoDtoRequest(

        @NotBlank
        @Length(max = 100)
        String logradouro,

        @NotBlank
        @Length(max = 10)
        String cep,

        @NotBlank
        @Length(max = 10)
        String numero,

        @NotBlank
        @Length(max = 100)
        String cidade,

        @NotNull
        Boolean statusPrincipal
) { }

