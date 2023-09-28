package io.attornatusapirestjava.application.core.usecase;

import io.attornatusapirestjava.application.core.domain.Endereco;
import io.attornatusapirestjava.application.ports.in.EnderecoCriarInputPort;
import io.attornatusapirestjava.application.ports.out.EnderecoSalvarOutputPort;

import java.util.logging.Logger;

public class EnderecoCriarUseCase implements EnderecoCriarInputPort {

    private final Logger logger = Logger.getLogger(EnderecoCriarUseCase.class.getName());

    private final EnderecoSalvarOutputPort enderecoSalvarOutputPort;

    public EnderecoCriarUseCase(EnderecoSalvarOutputPort enderecoSalvarOutputPort) {
        this.enderecoSalvarOutputPort = enderecoSalvarOutputPort;
    }

    @Override
    public Endereco criar(final Long idPessoa, Endereco endereco) {

        logger.info("Criar endereço.");

        return this.enderecoSalvarOutputPort.salvar(endereco);
    }
}

