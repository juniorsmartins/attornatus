package io.attornatusapirestjava.configs.bean;

import io.attornatusapirestjava.adapters.out.PessoaConsultarAdapter;
import io.attornatusapirestjava.adapters.out.PessoaEditarAdapter;
import io.attornatusapirestjava.adapters.out.PessoaListarAdapter;
import io.attornatusapirestjava.adapters.out.PessoaSalvarAdapter;
import io.attornatusapirestjava.application.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaConfig {

    @Bean
    public PessoaCriarUseCase pessoaCriarUseCase(PessoaSalvarAdapter pessoaSalvarAdapter,
                                                 EnderecoCriarUseCase enderecoCriarUseCase) {
        return new PessoaCriarUseCase(pessoaSalvarAdapter, enderecoCriarUseCase);
    }

    @Bean
    public PessoaConsultarUseCase pessoaConsultarUseCase(PessoaConsultarAdapter pessoaConsultarAdapter) {
        return new PessoaConsultarUseCase(pessoaConsultarAdapter);
    }

    @Bean
    public PessoaListarUseCase pessoaListarUseCase(PessoaListarAdapter pessoaListarAdapter) {
        return new PessoaListarUseCase(pessoaListarAdapter);
    }

    @Bean
    public PessoaEditarUseCase pessoaEditarUseCase(PessoaEditarAdapter pessoaEditarAdapter,
                                                   PessoaConsultarUseCase pessoaConsultarUseCase) {
        return new PessoaEditarUseCase(pessoaEditarAdapter, pessoaConsultarUseCase);
    }
}

