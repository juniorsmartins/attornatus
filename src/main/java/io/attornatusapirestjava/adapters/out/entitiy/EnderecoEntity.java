package io.attornatusapirestjava.adapters.out.entitiy;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "enderecos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public final class EnderecoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "cep", length = 10, nullable = false)
    private String cep;

    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;

    @Column(name = "status_principal", nullable = false)
    private Boolean statusPrincipal;
}

