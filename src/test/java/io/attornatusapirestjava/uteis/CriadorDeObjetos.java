package io.attornatusapirestjava.uteis;

import com.github.javafaker.Faker;
import io.attornatusapirestjava.adapters.in.request.PessoaDtoRequest;
import io.attornatusapirestjava.adapters.in.request.PessoaEditarDtoRequest;
import io.attornatusapirestjava.adapters.out.entitiy.PessoaEntity;

import java.time.LocalDate;

public final class CriadorDeObjetos {

  public static Faker faker = new Faker();

  public static PessoaDtoRequest fabricarPessoaDtoRequest() {

    return new PessoaDtoRequest(
        faker.name().fullName(), ("1" + faker.numerify("#") + "/10/19" + faker.numerify("##"))
    );
  }

  public static PessoaEditarDtoRequest fabricarPessoaEditarDtoRequest(Long id) {

    return new PessoaEditarDtoRequest(
            id, faker.name().fullName(), ("1" + faker.numerify("#") + "/10/19" + faker.numerify("##"))
    );
  }

  public static PessoaEntity fabricarPessoaEntity() {

    var ano = Integer.parseInt("19" + faker.numerify("##"));
    var dia = Integer.parseInt("1" + faker.numerify("#"));
    var dataNascimento = LocalDate.of(ano, 10, dia);

    return PessoaEntity.builder()
        .nome(faker.name().fullName())
        .dataNascimentoLocalDate(dataNascimento)
        .build();
  }

//  public static ClienteDao.ClienteDaoBuilder gerarClienteDaoBuilder() {
//
//    return ClienteDao.builder()
//      .nome(faker.name().fullName())
//      .cpf(cpfGenerator.cpf(false))
//      .numeroTelefone(faker.numerify("###########"))
//      .email(faker.internet().emailAddress())
//      .dataNascimentoLocalDate(LocalDate.now());
//  }

//  public static ClienteDtoRequest.ClienteDtoRequestBuilder gerarClienteDtoRequestBuilder() {
//
//    return ClienteDtoRequest.builder()
//      .nome(faker.name().fullName())
//      .cpf(cpfGenerator.cpf(false))
//      .numeroTelefone(faker.numerify("###########"))
//      .email(faker.internet().emailAddress())
//      .dataNascimentoString("1" + faker.numerify("#") + "/10/19" + faker.numerify("##"));
//  }
}

