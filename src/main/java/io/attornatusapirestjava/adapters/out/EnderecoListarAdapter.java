package io.attornatusapirestjava.adapters.out;

import io.attornatusapirestjava.adapters.out.mapper.EnderecoEntityMapper;
import io.attornatusapirestjava.adapters.out.repository.EnderecoRepository;
import io.attornatusapirestjava.application.core.domain.Endereco;
import io.attornatusapirestjava.application.ports.out.EnderecoListarOutputPort;
import io.attornatusapirestjava.configs.exception.http_500.FalhaAoListarEnderecosException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class EnderecoListarAdapter implements EnderecoListarOutputPort {

    private final Logger logger = Logger.getLogger(EnderecoListarAdapter.class.getName());

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoEntityMapper enderecoEntityMapper;

    @Transactional
    @Override
    public Set<Endereco> listarPorPessoa(final Long id) {

        logger.info("Iniciado procedimento de listar endereços por pessoa no Adapter.");

        var enderecos = Optional.of(id)
            .map(this.enderecoRepository::findByPessoaId)
            .map(this.enderecoEntityMapper::toSetEnderecos)
            .orElseThrow(FalhaAoListarEnderecosException::new);

        logger.info("Finalizado procedimento de listar endereços por pessoa no Adapter.");

        return enderecos;
    }
}

