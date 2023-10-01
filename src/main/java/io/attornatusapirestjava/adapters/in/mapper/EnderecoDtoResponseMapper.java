package io.attornatusapirestjava.adapters.in.mapper;

import io.attornatusapirestjava.adapters.in.response.EnderecoDtoResponse;
import io.attornatusapirestjava.application.core.domain.Endereco;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface EnderecoDtoResponseMapper {

    EnderecoDtoResponse toEnderecoDtoResponse(Endereco endereco);

    Set<EnderecoDtoResponse> toSetEnderecosDtoResponse(Set<Endereco> enderecos);
}

