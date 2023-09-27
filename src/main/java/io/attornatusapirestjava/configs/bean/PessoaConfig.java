package io.attornatusapirestjava.configs.bean;

import io.attornatusapirestjava.adapters.out.PessoaSalvarAdapter;
import io.attornatusapirestjava.application.core.usecase.PessoaCriarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaConfig {

    @Bean
    public PessoaCriarUseCase pessoaCriarUseCase(PessoaSalvarAdapter pessoaSalvarAdapter) {
        return new PessoaCriarUseCase(pessoaSalvarAdapter);
    }
}

