package io.attornatusapirestjava.application.core.domain;

import java.util.Objects;

public final class Endereco {

    private Long id;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

    private Boolean statusPrincipal;

    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Boolean getStatusPrincipal() {
        return statusPrincipal;
    }

    public void setStatusPrincipal(Boolean statusPrincipal) {
        this.statusPrincipal = statusPrincipal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(cep, endereco.cep) && Objects.equals(numero, endereco.numero) && Objects.equals(cidade, endereco.cidade) && Objects.equals(statusPrincipal, endereco.statusPrincipal) && Objects.equals(pessoa, endereco.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logradouro, cep, numero, cidade, statusPrincipal, pessoa);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", statusPrincipal=" + statusPrincipal +
                ", pessoa=" + pessoa +
                '}';
    }
}

