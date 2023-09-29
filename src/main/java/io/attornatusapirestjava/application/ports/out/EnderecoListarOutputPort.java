package io.attornatusapirestjava.application.ports.out;

import io.attornatusapirestjava.application.core.domain.Endereco;

import java.util.Set;

public interface EnderecoListarOutputPort {

    Set<Endereco> listarPorPessoa(Long id);
}

