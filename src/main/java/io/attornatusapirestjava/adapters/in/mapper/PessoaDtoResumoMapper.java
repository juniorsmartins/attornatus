package io.attornatusapirestjava.adapters.in.mapper;

import io.attornatusapirestjava.adapters.in.request.PessoaDtoResumo;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaDtoResumoMapper {

    Pessoa toPessoa(PessoaDtoResumo pessoaDtoResumo);

    PessoaDtoResumo toPessoaDtoResumo(Pessoa pessoa);
}

