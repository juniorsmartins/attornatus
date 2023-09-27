package io.attornatusapirestjava.application.ports.out;

import io.attornatusapirestjava.application.core.domain.Pessoa;

import java.util.List;

public interface PessoaListarOutputPort {

    List<Pessoa> listar();
}

