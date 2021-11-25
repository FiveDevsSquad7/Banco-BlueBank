package com.banco.bluebank.model.dto.input;

import lombok.Getter;
import lombok.Setter;
/**
 * @name: ContaInputDTO
 * @categoria: Classe entidade
 * @description: Util para conversão e para "visualizar"
 * @author: Dev. Weslley Lima
 * @version: V1
 */
@Getter
@Setter
public class ContaInputDTO {

    private Integer numeroConta;
    private String tipoConta;
    private Integer digito;
    private Long idCorrentista;
    private Long idAgencia;

}
