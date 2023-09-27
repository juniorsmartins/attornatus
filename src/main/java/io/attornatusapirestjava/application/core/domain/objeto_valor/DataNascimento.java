package io.attornatusapirestjava.application.core.domain.objeto_valor;

import io.attornatusapirestjava.configs.exception.http_400.DataNascimentoInvalidaException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DataNascimento implements Serializable {

  public static final long serialVersionUID = 1L;

  public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private String dataNascimentoString;

  private LocalDate dataNascimentoLocalDate;

  public DataNascimento(String dataNascimentoString) {
    if (!this.ehValido(dataNascimentoString)) {
      throw new DataNascimentoInvalidaException(dataNascimentoString);
    }
    this.dataNascimentoLocalDate = LocalDate.parse(dataNascimentoString, FORMATO_DATA);
  }

  public DataNascimento(LocalDate dataNascimentoLocalDate) {
    this.dataNascimentoString = dataNascimentoLocalDate.format(FORMATO_DATA);
  }

  public boolean ehValido(String dataNascimentoString) {
    try {
      LocalDate.parse(dataNascimentoString, FORMATO_DATA);
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }

  public String getDataNascimentoString() {
    return dataNascimentoString;
  }

  public void setDataNascimentoString(String dataNascimentoString) {
    this.dataNascimentoString = dataNascimentoString;
  }

  public LocalDate getDataNascimentoLocalDate() {
    return dataNascimentoLocalDate;
  }

  public void setDataNascimentoLocalDate(LocalDate dataNascimentoLocalDate) {
    this.dataNascimentoLocalDate = dataNascimentoLocalDate;
  }
}

