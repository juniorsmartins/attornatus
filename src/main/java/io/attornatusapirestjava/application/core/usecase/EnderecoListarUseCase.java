package io.attornatusapirestjava.application.core.usecase;

import io.attornatusapirestjava.application.core.domain.Endereco;
import io.attornatusapirestjava.application.ports.in.EnderecoListarInputPort;
import io.attornatusapirestjava.application.ports.out.EnderecoListarOutputPort;

import java.util.Set;
import java.util.logging.Logger;

public class EnderecoListarUseCase implements EnderecoListarInputPort {

    private final Logger logger = Logger.getLogger(EnderecoListarUseCase.class.getName());

    private final EnderecoListarOutputPort enderecoListarOutputPort;

    public EnderecoListarUseCase(EnderecoListarOutputPort enderecoListarOutputPort) {
        this.enderecoListarOutputPort = enderecoListarOutputPort;
    }

    @Override
    public Set<Endereco> listarPorPessoa(final Long id) {

        logger.info("UseCase inicia procedimento de listar endereços por pessoa.");

        var enderecos = this.enderecoListarOutputPort.listarPorPessoa(id);

        logger.info("UseCase finaliza procedimento de listar endereços por pessoa.");

        return enderecos;
    }
}

