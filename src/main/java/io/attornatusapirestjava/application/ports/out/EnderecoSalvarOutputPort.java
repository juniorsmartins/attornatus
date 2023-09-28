package io.attornatusapirestjava.application.ports.out;

import io.attornatusapirestjava.application.core.domain.Endereco;

public interface EnderecoSalvarOutputPort {

    Endereco salvar(Endereco endereco);
}

