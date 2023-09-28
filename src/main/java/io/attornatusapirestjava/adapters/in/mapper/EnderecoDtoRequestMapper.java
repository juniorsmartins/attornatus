package io.attornatusapirestjava.adapters.in.mapper;

import io.attornatusapirestjava.adapters.in.request.EnderecoDtoRequest;
import io.attornatusapirestjava.application.core.domain.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoDtoRequestMapper {

    Endereco toEndereco(EnderecoDtoRequest enderecoDtoRequest);
}

