package io.attornatusapirestjava.adapters.out.mapper;

import io.attornatusapirestjava.adapters.out.entitiy.PessoaEntity;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaEntityMapper {

    PessoaEntity toPessoaEntity(Pessoa pessoa);

    Pessoa toPessoa(PessoaEntity pessoaEntity);
}

