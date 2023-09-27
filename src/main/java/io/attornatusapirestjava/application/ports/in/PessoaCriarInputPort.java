package io.attornatusapirestjava.application.ports.in;

import io.attornatusapirestjava.application.core.domain.Pessoa;

public interface PessoaCriarInputPort {

    Pessoa criar(Pessoa pessoa);
}

