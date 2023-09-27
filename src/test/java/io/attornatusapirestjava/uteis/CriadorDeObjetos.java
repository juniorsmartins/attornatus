package io.attornatusapirestjava.uteis;

import com.github.javafaker.Faker;
import io.attornatusapirestjava.adapters.in.request.PessoaDtoRequest;
import io.attornatusapirestjava.adapters.in.request.PessoaEditarDtoRequest;
import io.attornatusapirestjava.adapters.out.entitiy.PessoaEntity;

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

    return PessoaEntity.builder()
        .nome(faker.name().fullName())
        .dataNascimento("1" + faker.numerify("#") + "/10/19" + faker.numerify("##"))
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

