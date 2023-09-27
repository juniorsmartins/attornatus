package io.attornatusapirestjava.configs.exception;

import io.attornatusapirestjava.configs.exception.http_500.ErroInternoDoSistemaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@RestControllerAdvice
public final class TratamentoExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiErrorResponse> genericasException(Exception ex, WebRequest webRequest) {

        var apiErrorResponse = ApiErrorResponse.builder()
                .tipo(TipoDeErroEnum.ERRO_INTERNO_DE_SISTEMA.getCaminho())
                .titulo(TipoDeErroEnum.ERRO_INTERNO_DE_SISTEMA.getTitulo())
                .codigoHttp(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .statusHttp(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .detalhe(ex.getMessage())
                .instance(null)
                .dataHora(OffsetDateTime.now())
                .build();

        return ResponseEntity
                .internalServerError()
                .body(apiErrorResponse);
    }

    @ExceptionHandler(ErroInternoDoSistemaException.class)
    public final ResponseEntity<ApiErrorResponse> erroInternoException(ErroInternoDoSistemaException errInt, WebRequest webRequest) {

        var apiErrorResponse = ApiErrorResponse.builder()
                .tipo(TipoDeErroEnum.ERRO_INTERNO_DE_SISTEMA.getCaminho())
                .titulo(TipoDeErroEnum.ERRO_INTERNO_DE_SISTEMA.getTitulo())
                .codigoHttp(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .statusHttp(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .detalhe(errInt.getMessage())
                .instance(null)
                .dataHora(OffsetDateTime.now())
                .build();

        return ResponseEntity
                .internalServerError()
                .body(apiErrorResponse);
    }
}

