package io.attornatusapirestjava.adapters.in.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PessoaDtoResumo(

        @NotNull
        @Positive
        Long id
) { }

