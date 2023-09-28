package io.attornatusapirestjava.adapters.out.mapper;

import io.attornatusapirestjava.adapters.out.entitiy.EnderecoEntity;
import io.attornatusapirestjava.application.core.domain.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoEntityMapper {

    EnderecoEntity toEnderecoEntity(Endereco endereco);

    Endereco toEndereco(EnderecoEntity enderecoEntity);
}

