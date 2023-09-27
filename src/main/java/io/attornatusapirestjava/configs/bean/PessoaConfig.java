package io.attornatusapirestjava.configs.bean;

import io.attornatusapirestjava.adapters.out.PessoaConsultarAdapter;
import io.attornatusapirestjava.adapters.out.PessoaListarAdapter;
import io.attornatusapirestjava.adapters.out.PessoaSalvarAdapter;
import io.attornatusapirestjava.application.core.usecase.PessoaConsultarUseCase;
import io.attornatusapirestjava.application.core.usecase.PessoaCriarUseCase;
import io.attornatusapirestjava.application.core.usecase.PessoaListarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaConfig {

    @Bean
    public PessoaCriarUseCase pessoaCriarUseCase(PessoaSalvarAdapter pessoaSalvarAdapter) {
        return new PessoaCriarUseCase(pessoaSalvarAdapter);
    }

    @Bean
    public PessoaConsultarUseCase pessoaConsultarUseCase(PessoaConsultarAdapter pessoaConsultarAdapter) {
        return new PessoaConsultarUseCase(pessoaConsultarAdapter);
    }

    @Bean
    public PessoaListarUseCase pessoaListarUseCase(PessoaListarAdapter pessoaListarAdapter) {
        return new PessoaListarUseCase(pessoaListarAdapter);
    }
}

