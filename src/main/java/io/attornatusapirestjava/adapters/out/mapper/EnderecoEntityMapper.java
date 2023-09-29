package io.attornatusapirestjava.adapters.out.mapper;

import io.attornatusapirestjava.adapters.out.entitiy.EnderecoEntity;
import io.attornatusapirestjava.application.core.domain.Endereco;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface EnderecoEntityMapper {

    EnderecoEntity toEnderecoEntity(Endereco endereco);

    Endereco toEndereco(EnderecoEntity enderecoEntity);

    Set<EnderecoEntity> toSetEnderecosEntity(Set<Endereco> enderecos);

    Set<Endereco> toSetEnderecos(Set<EnderecoEntity> enderecos);
}

