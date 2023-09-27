package io.attornatusapirestjava.adapters.in.mapper;

import io.attornatusapirestjava.adapters.in.request.PessoaEditarDtoRequest;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaEditarDtoRequestMapper {

    Pessoa toPessoa(PessoaEditarDtoRequest pessoaEditarDtoRequest);
}

