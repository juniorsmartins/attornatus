package io.attornatusapirestjava.adapters.in.mapper;

import io.attornatusapirestjava.adapters.in.response.PessoaDtoResponse;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaDtoResponseMapper {

    PessoaDtoResponse toPessoaDtoResponse(Pessoa pessoa);
}

