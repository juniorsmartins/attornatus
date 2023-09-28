package io.attornatusapirestjava.adapters.in.mapper;

import io.attornatusapirestjava.adapters.in.response.EnderecoDtoResponse;
import io.attornatusapirestjava.application.core.domain.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoDtoResponseMapper {

    EnderecoDtoResponse toEnderecoDtoResponse(Endereco endereco);
}

