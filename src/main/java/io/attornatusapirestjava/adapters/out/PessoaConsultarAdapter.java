package io.attornatusapirestjava.adapters.out;

import io.attornatusapirestjava.adapters.out.mapper.PessoaEntityMapper;
import io.attornatusapirestjava.adapters.out.repository.PessoaRepository;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.out.PessoaConsultarOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class PessoaConsultarAdapter implements PessoaConsultarOutputPort {

    private final Logger logger = Logger.getLogger(PessoaConsultarAdapter.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public Optional<Pessoa> consultar(final Long id) {

        logger.info("Consultar uma pessoa.");
        return this.pessoaRepository.findById(id)
                .map(this.pessoaEntityMapper::toPessoa);
    }
}

