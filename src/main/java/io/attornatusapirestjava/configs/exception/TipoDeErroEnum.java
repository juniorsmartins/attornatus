package io.attornatusapirestjava.configs.exception;

import lombok.Getter;

@Getter
public enum TipoDeErroEnum {

    ENTIDADE_NAO_ENCONTRADA("Entidade não encontrada.", "/entidade-nao-encontrada"),
    REQUISICAO_MAL_FORMULADA("Requisição mal formulada.", "/requisicao-mal-formulada"),
    ERRO_INTERNO_DE_SISTEMA("Erro interno de sistema.", "/erro-interno-de-sistema");

    private final String titulo;

    private final String caminho;

    TipoDeErroEnum(String titulo, String caminho) {
        this.titulo = titulo;
        this.caminho = caminho;
    }
}

