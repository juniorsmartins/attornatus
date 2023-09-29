package io.attornatusapirestjava.adapters.out;

import io.attornatusapirestjava.adapters.out.mapper.PessoaEntityMapper;
import io.attornatusapirestjava.adapters.out.repository.PessoaRepository;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.ports.out.PessoaListarOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Component
public class PessoaListarAdapter implements PessoaListarOutputPort {

    private final Logger logger = Logger.getLogger(PessoaListarAdapter.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public List<Pessoa> listar() {

        logger.info("Adapter inicia procedimento de listar pessoas.");

        var pessoas = this.pessoaRepository.findAll()
                .stream()
                .map(this.pessoaEntityMapper::toPessoa)
                .sorted(Comparator.comparing(Pessoa::getId).reversed())
                .toList();

        logger.info("Adapter finaliza procedimento de listar pessoas.");

        return pessoas;
    }
}

