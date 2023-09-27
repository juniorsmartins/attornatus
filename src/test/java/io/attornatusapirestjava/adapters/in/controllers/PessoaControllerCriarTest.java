package io.attornatusapirestjava.adapters.in.controllers;

import io.attornatusapirestjava.AttornatusApiRestJavaApplication;
import io.attornatusapirestjava.uteis.CriadorDeObjetos;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = AttornatusApiRestJavaApplication.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PessoaControllerCriarTest {

    public static final String END_POINT = "/api/v1/pessoas";

    public static final String UTF8 = "UTF-8";

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void criadorDeCenario() {

    }

    @AfterEach
    void destruidorDeCenario() {

    }

    @Test
    @Order(1)
    @DisplayName("Criar - Http 201")
    void deveRetornarHttp201_quandoCriar() {

        var dtoRequest = CriadorDeObjetos.fabricarPessoaDtoRequest();


    }
}