package io.attornatusapirestjava.adapters.in.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PessoaDtoResponse {

    private Long id;

    private String nome;

    private String dataNascimento;
}

