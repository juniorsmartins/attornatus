package io.attornatusapirestjava.application.ports.in;

import io.attornatusapirestjava.application.core.domain.Endereco;

import java.util.Set;

public interface EnderecoListarInputPort {

    Set<Endereco> listarPorPessoa(Long id);
}

