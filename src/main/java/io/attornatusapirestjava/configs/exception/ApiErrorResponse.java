package io.attornatusapirestjava.configs.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse {

    private String tipo; // Um URI que identifica o tipo de problema. Deve fornecer documentação (como página de erro ou um link).

    private String titulo; // Um título curto, em linguagem humana, que resume o problema.

    private int codigoHttp; // Código Http

    private String statusHttp; // Nome do status HTTP gerado por esta ocorrência do problema.

    private String detalhe; // Uma explicação em linguagem humana que fornece detalhes sobre a ocorrência específica do problema.

    private String instance; // Um URI que identifica a ocorrência específica do problema. Pode ou não ser resolvível.

    private OffsetDateTime dataHora;

    private List<Erro> erros;

    @Builder
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Erro {

        private String anotacaoViolada; // Nome da anotação violada do Bean Validation

        private String localDeErro; // Nome do campo em que a anotação foi violada

        private String motivo; // explicação sobre o motivo do erro
    }
}

