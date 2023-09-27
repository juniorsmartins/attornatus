package io.attornatusapirestjava.application.ports.in;

import io.attornatusapirestjava.application.core.domain.Pessoa;

import java.util.List;

public interface PessoaListarInputPort {

    List<Pessoa> listar();
}

