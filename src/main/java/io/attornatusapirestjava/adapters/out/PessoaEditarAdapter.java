package io.attornatusapirestjava.adapters.out;

import io.attornatusapirestjava.adapters.out.mapper.PessoaEntityMapper;
import io.attornatusapirestjava.adapters.out.repository.PessoaRepository;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.out.PessoaEditarOutputPort;
import io.attornatusapirestjava.configs.exception.http_500.FalhaAoEditarPessoaException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class PessoaEditarAdapter implements PessoaEditarOutputPort {

    private final Logger logger = Logger.getLogger(PessoaEditarAdapter.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Transactional
    @Override
    public Pessoa editar(Pessoa pessoa) {

        logger.info("Editar pessoa.");

        return Optional.of(pessoa)
            .map(this.pessoaEntityMapper::toPessoaEntity)
            .map(this.pessoaRepository::save)
            .map(this.pessoaEntityMapper::toPessoa)
            .orElseThrow(FalhaAoEditarPessoaException::new);
    }
}

