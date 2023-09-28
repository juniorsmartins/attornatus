package io.attornatusapirestjava.application.core.domain;

public final class Endereco {

    private Long id;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

    private Boolean statusPrincipal;

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
}

