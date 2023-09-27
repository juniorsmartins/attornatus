package io.attornatusapirestjava.adapters.out.repository;

import io.attornatusapirestjava.adapters.out.entitiy.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> { }

