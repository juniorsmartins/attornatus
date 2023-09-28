package io.attornatusapirestjava.application.ports.in;

import io.attornatusapirestjava.application.core.domain.Endereco;

public interface EnderecoCriarInputPort {

    Endereco criar(Long idPessoa, Endereco endereco);
}

