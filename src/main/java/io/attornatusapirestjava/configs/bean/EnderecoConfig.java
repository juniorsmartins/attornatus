package io.attornatusapirestjava.configs.bean;

import io.attornatusapirestjava.adapters.out.EnderecoSalvarAdapter;
import io.attornatusapirestjava.adapters.out.PessoaConsultarAdapter;
import io.attornatusapirestjava.application.core.usecase.EnderecoCriarUseCase;
import io.attornatusapirestjava.application.core.usecase.PessoaConsultarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnderecoConfig {

    @Bean
    public EnderecoCriarUseCase enderecoCriarUseCase(EnderecoSalvarAdapter enderecoSalvarAdapter,
                                                     PessoaConsultarUseCase pessoaConsultarUseCase) {
        return new EnderecoCriarUseCase(enderecoSalvarAdapter, pessoaConsultarUseCase);
    }
}

