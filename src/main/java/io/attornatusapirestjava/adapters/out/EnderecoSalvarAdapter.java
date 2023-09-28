package io.attornatusapirestjava.adapters.out;

import io.attornatusapirestjava.adapters.out.mapper.EnderecoEntityMapper;
import io.attornatusapirestjava.adapters.out.repository.EnderecoRepository;
import io.attornatusapirestjava.application.core.domain.Endereco;
import io.attornatusapirestjava.application.ports.out.EnderecoSalvarOutputPort;
import io.attornatusapirestjava.configs.exception.http_500.FalhaAoCriarEnderecoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class EnderecoSalvarAdapter implements EnderecoSalvarOutputPort {

    private final Logger logger = Logger.getLogger(EnderecoSalvarAdapter.class.getName());

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoEntityMapper enderecoEntityMapper;

    @Override
    public Endereco salvar(Endereco endereco) {

        logger.info("Criar endereço.");

        return Optional.of(endereco)
            .map(this.enderecoEntityMapper::toEnderecoEntity)
            .map(this.enderecoRepository::save)
            .map(this.enderecoEntityMapper::toEndereco)
            .orElseThrow(FalhaAoCriarEnderecoException::new);
    }
}

