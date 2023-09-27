package io.attornatusapirestjava.application.ports.in;

import io.attornatusapirestjava.application.core.domain.Pessoa;

public interface PessoaConsultarInputPort {

    Pessoa consultar(Long id);
}

