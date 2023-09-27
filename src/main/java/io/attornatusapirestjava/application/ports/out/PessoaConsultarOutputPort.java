package io.attornatusapirestjava.application.ports.out;

import io.attornatusapirestjava.application.core.domain.Pessoa;

import java.util.Optional;

public interface PessoaConsultarOutputPort {

    Optional<Pessoa> consultar(Long id);
}

