package com.banco.bluebank.model.dto.output;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Correntista;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaOutputDTO {

    private Long id;
    private Integer numeroConta;
    private Integer digito;
    private String tipoConta;
    private CorrentistaOutputDTO correntista;
    private AgenciaOutputDTO agencia;

}
