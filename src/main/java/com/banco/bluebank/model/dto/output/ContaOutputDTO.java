package com.banco.bluebank.model.dto.output;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Correntista;
import lombok.Getter;
import lombok.Setter;

/**
 * @name: ContaOutputDTO
 * @categoria: Classe entidade
 * @description: Util para conversão e para "visualizar"
 * @author: Dev. Weslley Lima
 * @version: V1
 */
@Getter
@Setter
public class ContaOutputDTO {

    private Long id;
    private Integer numeroConta;
    private String tipoConta;
    private String nomeAgencia;
    private Long idCorrentista;
    private String nomeCorrentista;
    private String cpf;
    private String rg;
    private String cnpj;
    private Long idAgencia;
    private Integer digito;

}
