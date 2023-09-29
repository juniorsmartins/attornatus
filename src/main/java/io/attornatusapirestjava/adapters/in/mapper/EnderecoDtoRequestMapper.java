package io.attornatusapirestjava.adapters.in.mapper;

import io.attornatusapirestjava.adapters.in.request.EnderecoDtoRequest;
import io.attornatusapirestjava.application.core.domain.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface EnderecoDtoRequestMapper {

    @Mapping(target = "pessoa", ignore = true)
    Endereco toEndereco(EnderecoDtoRequest enderecoDtoRequest);

    Set<Endereco> toSetEnderecos(Set<EnderecoDtoRequest> enderecos);
}

