package io.attornatusapirestjava.adapters.in.controllers;

import io.attornatusapirestjava.AttornatusApiRestJavaApplication;
import io.attornatusapirestjava.adapters.out.entitiy.PessoaEntity;
import io.attornatusapirestjava.adapters.out.repository.PessoaRepository;
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
class PessoaControllerConsultarTest {

    public static final String END_POINT = "/api/v1/pessoas/";

    public static final String UTF8 = "UTF-8";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PessoaRepository pessoaRepository;

    private PessoaEntity pessoaEntity;

    @BeforeEach
    void criadorDeCenario() {

        pessoaEntity = this.pessoaRepository.save(CriadorDeObjetos.fabricarPessoaEntity());
    }

    @AfterEach
    void destruidorDeCenario() {

        this.pessoaRepository.deleteAll();
    }

    @Test
    @Order(1)
    @DisplayName("Consultar - Http 200")
    void deveRetornarHttp200_quandoConsultar() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(END_POINT + pessoaEntity.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}