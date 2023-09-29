package io.attornatusapirestjava.adapters.out.repository;

import io.attornatusapirestjava.adapters.out.entitiy.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

    Set<EnderecoEntity> findByPessoaId(Long pessoaId);
}

