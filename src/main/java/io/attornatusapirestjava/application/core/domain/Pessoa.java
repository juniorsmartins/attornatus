package io.attornatusapirestjava.application.core.domain;

import io.attornatusapirestjava.application.core.domain.objeto_valor.DataNascimento;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Pessoa {

    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long id;

    private String nome;

    private DataNascimento dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimentoString(String dataNascimento) {
        if (ObjectUtils.isNotEmpty(dataNascimento)) {
            this.dataNascimento = new DataNascimento(dataNascimento);
        }
    }

    public String getDataNascimento() {
        if (ObjectUtils.isNotEmpty(this.dataNascimento)) {
            return this.dataNascimento.getDataNascimentoString();
        }
        return null;
    }

    public void setDataNascimentoLocalDate(LocalDate dataNascimento) {
        if (ObjectUtils.isNotEmpty(dataNascimento)) {
            this.dataNascimento = new DataNascimento(dataNascimento);
        }
    }

    public LocalDate getDataNascimentoLocalDate() {
        if (ObjectUtils.isNotEmpty(this.dataNascimento)) {
            return this.dataNascimento.getDataNascimentoLocalDate();
        }
        return null;
    }
}

