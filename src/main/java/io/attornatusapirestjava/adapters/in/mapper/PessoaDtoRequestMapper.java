package io.attornatusapirestjava.adapters.in.mapper;

import io.attornatusapirestjava.adapters.in.request.PessoaDtoRequest;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaDtoRequestMapper {

    Pessoa toPessoa(PessoaDtoRequest pessoaDtoRequest);
}

