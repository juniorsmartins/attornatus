package io.attornatusapirestjava.application.core.usecase;

import io.attornatusapirestjava.application.core.domain.Endereco;
import io.attornatusapirestjava.application.ports.in.EnderecoCriarInputPort;
import io.attornatusapirestjava.application.ports.in.PessoaConsultarInputPort;
import io.attornatusapirestjava.application.ports.out.EnderecoSalvarOutputPort;
import jakarta.transaction.Transactional;

import java.util.logging.Logger;

public class EnderecoCriarUseCase implements EnderecoCriarInputPort {

    private final Logger logger = Logger.getLogger(EnderecoCriarUseCase.class.getName());

    private final EnderecoSalvarOutputPort enderecoSalvarOutputPort;

    private final PessoaConsultarInputPort pessoaConsultarInputPort;

    public EnderecoCriarUseCase(EnderecoSalvarOutputPort enderecoSalvarOutputPort,
                                PessoaConsultarInputPort pessoaConsultarInputPort) {
        this.enderecoSalvarOutputPort = enderecoSalvarOutputPort;
        this.pessoaConsultarInputPort = pessoaConsultarInputPort;
    }

    @Transactional
    @Override
    public Endereco criar(final Long idPessoa, Endereco endereco) {

        logger.info("Iniciado procedimento de criar um endereço no UseCase.");

        var pessoa = this.pessoaConsultarInputPort.consultar(idPessoa);
        endereco.setPessoa(pessoa);
        var enderecoSalvo = this.enderecoSalvarOutputPort.salvar(endereco);

        logger.info("Finalizado procedimento de criar um endereço no UseCase.");

        return enderecoSalvo;
    }
}

