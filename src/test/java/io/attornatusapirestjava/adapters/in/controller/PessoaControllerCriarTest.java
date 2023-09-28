package io.attornatusapirestjava.adapters.in.controller;

import io.attornatusapirestjava.AttornatusApiRestJavaApplication;
import io.attornatusapirestjava.adapters.out.repository.PessoaRepository;
import io.attornatusapirestjava.uteis.Conversor;
import io.attornatusapirestjava.uteis.CriadorDeObjetos;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = AttornatusApiRestJavaApplication.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PessoaControllerCriarTest {

    public static final String END_POINT = "/api/v1/pessoas";

    public static final String UTF8 = "UTF-8";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void criadorDeCenario() {

    }

    @AfterEach
    void destruidorDeCenario() {

        this.pessoaRepository.deleteAll();
    }

    @Test
    @Order(1)
    @DisplayName("Criar - Http 201")
    void deveRetornarHttp201_quandoCriar() throws Exception {

        var dtoRequest = CriadorDeObjetos.fabricarPessoaDtoRequest();

        this.mockMvc.perform(MockMvcRequestBuilders.post(END_POINT)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(UTF8)
            .content(Conversor.converterObjetoParaJson(dtoRequest))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andDo(MockMvcResultHandlers.print());
    }
}