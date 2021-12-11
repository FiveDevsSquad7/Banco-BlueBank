package com.banco.bluebank.model.dto.output;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Correntista;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ContaOutputDTO {

    private Long numeroConta;
    private String digito;
    private String numeroContaCompleta;
    private String tipoConta;
    private OffsetDateTime dataCadastro;
    private CorrentistaOutputDTO correntista;
    private AgenciaOutputDTO agencia;

}
