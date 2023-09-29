package io.attornatusapirestjava.application.core.usecase;

import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.in.PessoaCriarInputPort;
import io.attornatusapirestjava.application.ports.out.PessoaSalvarOutputPort;

import java.util.logging.Logger;

public class PessoaCriarUseCase implements PessoaCriarInputPort {

    private final Logger logger = Logger.getLogger(PessoaCriarUseCase.class.getName());

    private final PessoaSalvarOutputPort pessoaSalvarOutputPort;

    public PessoaCriarUseCase(PessoaSalvarOutputPort pessoaSalvarOutputPort) {
        this.pessoaSalvarOutputPort = pessoaSalvarOutputPort;
    }

    @Override
    public Pessoa criar(Pessoa pessoa) {

        logger.info("UseCase inicia procedimento de criar uma pessoa.");

        var pessoaSalva = this.pessoaSalvarOutputPort.salvar(pessoa);

        logger.info("UseCase finaliza procedimento de criar uma pessoa.");

        return pessoaSalva;
    }
}

