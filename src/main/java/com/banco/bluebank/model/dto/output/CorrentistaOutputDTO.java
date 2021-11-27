package com.banco.bluebank.model.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorrentistaOutputDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String cnpj;

}
