package io.attornatusapirestjava.adapters.out;

import io.attornatusapirestjava.adapters.out.mapper.PessoaEntityMapper;
import io.attornatusapirestjava.adapters.out.repository.PessoaRepository;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.out.PessoaSalvarOutputPort;
import io.attornatusapirestjava.configs.exception.http_500.FalhaAoSalvarPessoaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class PessoaSalvarAdapter implements PessoaSalvarOutputPort {

    private final Logger logger = Logger.getLogger(PessoaSalvarAdapter.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public Pessoa salvar(Pessoa pessoa) {

        logger.info("Iniciado procedimento de salvar pessoa no Adapter.");

        pessoa.getEnderecos().forEach(endereco -> System.out.println("\n" + endereco.toString()));

        var pessoaSalva = Optional.of(pessoa)
                .map(this.pessoaEntityMapper::toPessoaEntity)
                .map(this.pessoaRepository::saveAndFlush)
                .map(this.pessoaEntityMapper::toPessoa)
                .orElseThrow(FalhaAoSalvarPessoaException::new);

        logger.info("Finalizado procedimento de salvar pessoa no Adapter.");

        return pessoaSalva;
    }
}

