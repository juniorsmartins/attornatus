package io.attornatusapirestjava.application.core.usecase;

import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.in.PessoaConsultarInputPort;
import io.attornatusapirestjava.application.ports.in.PessoaEditarInputPort;
import io.attornatusapirestjava.application.ports.out.PessoaEditarOutputPort;

import java.util.logging.Logger;

public class PessoaEditarUseCase implements PessoaEditarInputPort {

    private final Logger logger = Logger.getLogger(PessoaEditarUseCase.class.getName());

    private final PessoaEditarOutputPort pessoaEditarOutputPort;

    private final PessoaConsultarInputPort pessoaConsultarInputPort;

    public PessoaEditarUseCase(PessoaEditarOutputPort pessoaEditarOutputPort,
                               PessoaConsultarInputPort pessoaConsultarInputPort) {
        this.pessoaEditarOutputPort = pessoaEditarOutputPort;
        this.pessoaConsultarInputPort = pessoaConsultarInputPort;
    }

    @Override
    public Pessoa editar(Pessoa pessoa) {

        logger.info("Editar pessoa.");

        this.pessoaConsultarInputPort.consultar(pessoa.getId());
        return this.pessoaEditarOutputPort.editar(pessoa);
    }
}

