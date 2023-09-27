package io.attornatusapirestjava.application.core.usecase;

import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.in.PessoaConsultarInputPort;
import io.attornatusapirestjava.application.ports.out.PessoaConsultarOutputPort;
import io.attornatusapirestjava.configs.exception.http_400.PessoaNaoEncontradaException;

import java.util.logging.Logger;

public class PessoaConsultarUseCase implements PessoaConsultarInputPort {

    private final Logger logger = Logger.getLogger(PessoaConsultarUseCase.class.getName());

    private final PessoaConsultarOutputPort pessoaConsultarOutputPort;

    public PessoaConsultarUseCase(PessoaConsultarOutputPort pessoaConsultarOutputPort) {
        this.pessoaConsultarOutputPort = pessoaConsultarOutputPort;
    }

    @Override
    public Pessoa consultar(final Long id) {

        logger.info("Consultar uma pessoa.");
        return this.pessoaConsultarOutputPort.consultar(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }
}

