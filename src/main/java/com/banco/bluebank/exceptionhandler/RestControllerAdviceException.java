package com.banco.bluebank.exceptionhandler;
import com.banco.bluebank.exceptionhandler.exceptions.agencia.AgenciaVaziaException;
import com.banco.bluebank.exceptionhandler.exceptions.agencia.PesquisarAgenciaPorIdException;
import com.banco.bluebank.exceptionhandler.exceptions.conta.CadastroDeContaException;
import com.banco.bluebank.exceptionhandler.exceptions.conta.PesquisarContaPorIdException;
import com.banco.bluebank.exceptionhandler.exceptions.conta.PesquisarContaPorStatusException;
import com.banco.bluebank.exceptionhandler.exceptions.correntista.CorrentistaSemCadastroException;
import com.banco.bluebank.exceptionhandler.exceptions.saldo.PesquisarSaldoPorIDException;
import com.banco.bluebank.exceptionhandler.exceptions.validation.CampoErro;
import com.banco.bluebank.exceptionhandler.exceptions.validation.ValidacaoDeArgumentoException;
import com.banco.bluebank.exceptionhandler.exceptions.validation.ValidacaoDeSemArgsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestControllerAdviceException  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidacaoDeArgumentoException validacaoDeArgumentoException = new ValidacaoDeArgumentoException(
                "Validação de campo",
                status.value(),
                status.getReasonPhrase(),
                obterErrosDeValidacaoDeCampos(ex)
        );
        return ResponseEntity.status(status).body(validacaoDeArgumentoException);
    }

    private List<CampoErro> obterErrosDeValidacaoDeCampos(MethodArgumentNotValidException exception) {
        List<CampoErro> campoErros = new ArrayList<>();
        for (FieldError fieldError : exception.getFieldErrors()) {
            campoErros.add(new CampoErro(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return campoErros;
    }

    @ExceptionHandler({AgenciaVaziaException.class})
    @ResponseStatus(HttpStatus.OK)
    public ValidacaoDeSemArgsException agenciaVaziaException(AgenciaVaziaException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({PesquisarAgenciaPorIdException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException PesquisarAgenciaPorIdException(PesquisarAgenciaPorIdException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({CadastroDeContaException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException cadastroDeContaException(CadastroDeContaException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({PesquisarContaPorIdException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException pesquisarContaPorIdException(PesquisarContaPorIdException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({PesquisarContaPorStatusException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException pesquisarContaPorStatusException(PesquisarContaPorStatusException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({CorrentistaSemCadastroException.class})
    @ResponseStatus(HttpStatus.OK)
    public ValidacaoDeSemArgsException correntistaSemCadastroException(CorrentistaSemCadastroException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({PesquisarSaldoPorIDException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException pesquisarSaldoPorIDException(PesquisarSaldoPorIDException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }
}