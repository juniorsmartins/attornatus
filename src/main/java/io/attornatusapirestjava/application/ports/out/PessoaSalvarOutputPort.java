package io.attornatusapirestjava.application.ports.out;

import io.attornatusapirestjava.application.core.domain.Pessoa;

public interface PessoaSalvarOutputPort {

    Pessoa salvar(Pessoa pessoa);
}

