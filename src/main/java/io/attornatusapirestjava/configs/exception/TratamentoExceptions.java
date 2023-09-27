package io.attornatusapirestjava.configs.exception;

import io.attornatusapirestjava.configs.exception.http_400.RequisicaoMalFormuladaException;
import io.attornatusapirestjava.configs.exception.http_404.RecursoNaoEncontradoException;
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
    public ResponseEntity<ApiErrorResponse> geralException(Exception ex, WebRequest webRequest) {

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
    public ResponseEntity<ApiErrorResponse> erroInternoException(ErroInternoDoSistemaException errInt, WebRequest webRequest) {

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

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ApiErrorResponse> recursoNaoEncontradoException(RecursoNaoEncontradoException ex, WebRequest webRequest) {

        var apiErrorResponse = ApiErrorResponse.builder()
                .tipo(TipoDeErroEnum.RECURSO_NAO_ENCONTRADO.getCaminho())
                .titulo(TipoDeErroEnum.RECURSO_NAO_ENCONTRADO.getTitulo())
                .codigoHttp(HttpStatus.NOT_FOUND.value())
                .statusHttp(HttpStatus.NOT_FOUND.name())
                .detalhe(ex.getMessage())
                .instance(null)
                .dataHora(OffsetDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(apiErrorResponse);
    }

    @ExceptionHandler(RequisicaoMalFormuladaException.class)
    public ResponseEntity<ApiErrorResponse> requisicaoMalFormuladaException(RequisicaoMalFormuladaException ex, WebRequest webRequest) {

        var apiErrorResponse = ApiErrorResponse.builder()
                .tipo(TipoDeErroEnum.REQUISICAO_MAL_FORMULADA.getCaminho())
                .titulo(TipoDeErroEnum.REQUISICAO_MAL_FORMULADA.getTitulo())
                .codigoHttp(HttpStatus.BAD_REQUEST.value())
                .statusHttp(HttpStatus.BAD_REQUEST.name())
                .detalhe(ex.getMessage())
                .instance(null)
                .dataHora(OffsetDateTime.now())
                .build();

        return ResponseEntity
                .badRequest()
                .body(apiErrorResponse);
    }
}

