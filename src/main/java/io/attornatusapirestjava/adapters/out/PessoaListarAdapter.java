package io.attornatusapirestjava.adapters.out;

import io.attornatusapirestjava.adapters.out.mapper.PessoaEntityMapper;
import io.attornatusapirestjava.adapters.out.repository.PessoaRepository;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.out.PessoaListarOutputPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class PessoaListarAdapter implements PessoaListarOutputPort {

    private final Logger logger = Logger.getLogger(PessoaListarAdapter.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Transactional
    @Override
    public List<Pessoa> listar() {

        logger.info("Listar pessoas.");

        return this.pessoaRepository.findAll()
                .stream()
                .map(this.pessoaEntityMapper::toPessoa)
                .toList();
    }
}

