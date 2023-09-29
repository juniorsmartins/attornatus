package io.attornatusapirestjava.application.core.usecase;

import io.attornatusapirestjava.application.core.domain.Endereco;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.in.EnderecoCriarInputPort;
import io.attornatusapirestjava.application.ports.in.PessoaCriarInputPort;
import io.attornatusapirestjava.application.ports.out.PessoaSalvarOutputPort;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PessoaCriarUseCase implements PessoaCriarInputPort {

    private final Logger logger = Logger.getLogger(PessoaCriarUseCase.class.getName());

    private final PessoaSalvarOutputPort pessoaSalvarOutputPort;

    private final EnderecoCriarInputPort enderecoCriarInputPort;

    public PessoaCriarUseCase(PessoaSalvarOutputPort pessoaSalvarOutputPort,
                              EnderecoCriarInputPort enderecoCriarInputPort) {
        this.pessoaSalvarOutputPort = pessoaSalvarOutputPort;
        this.enderecoCriarInputPort = enderecoCriarInputPort;
    }

    @Transactional
    @Override
    public Pessoa criar(Pessoa pessoa) {

        logger.info("Iniciado procedimento de criar uma pessoa no UseCase.");

        pessoa.getEnderecos().forEach(endereco -> System.out.println("\n" + endereco.toString()));

        var pessoaSalva = this.pessoaSalvarOutputPort.salvar(pessoa);
        this.salvarEnderecos(pessoaSalva, pessoa.getEnderecos());

        logger.info("Finalizado procedimento de criar uma pessoa no UseCase.");

        return pessoaSalva;
    }

    private void salvarEnderecos(Pessoa pessoaSalva, Set<Endereco> enderecos) {
        if (Objects.nonNull(enderecos) && !enderecos.isEmpty()) {
            Set<Endereco> novosEnderecos = enderecos.stream()
                .map(endereco -> this.enderecoCriarInputPort.criar(pessoaSalva.getId(), endereco))
                .collect(Collectors.toSet());
            pessoaSalva.setEnderecos(novosEnderecos);
        }
    }
}

