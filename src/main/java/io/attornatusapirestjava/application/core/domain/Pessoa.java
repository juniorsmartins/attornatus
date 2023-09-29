package io.attornatusapirestjava.application.core.domain;

import io.attornatusapirestjava.application.core.domain.objeto_valor.DataNascimento;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Pessoa {

    private Long id;

    private String nome;

    private DataNascimento dataNascimento;

    private Set<Endereco> enderecos = new HashSet<>();

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

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", enderecos=" + enderecos +
                '}';
    }
}

