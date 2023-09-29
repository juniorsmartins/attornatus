package io.attornatusapirestjava.application.core.usecase;

import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.in.PessoaListarInputPort;
import io.attornatusapirestjava.application.ports.out.PessoaListarOutputPort;

import java.util.List;
import java.util.logging.Logger;

public class PessoaListarUseCase implements PessoaListarInputPort {

    private final Logger logger = Logger.getLogger(PessoaListarUseCase.class.getName());

    private final PessoaListarOutputPort pessoaListarOutputPort;

    public PessoaListarUseCase(PessoaListarOutputPort pessoaListarOutputPort) {
        this.pessoaListarOutputPort = pessoaListarOutputPort;
    }

    @Override
    public List<Pessoa> listar() {

        logger.info("UseCase inicia procedimento de listar pessoas.");

        var pessoas = this.pessoaListarOutputPort.listar();

        logger.info("UseCase finaliza procedimento de listar pessoas.");

        return pessoas;
    }
}

