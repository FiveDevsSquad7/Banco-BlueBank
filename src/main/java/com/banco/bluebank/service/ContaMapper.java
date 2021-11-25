package com.banco.bluebank.service;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.dto.input.ContaInputDTO;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @name: ContaMapper
 * @categoria: Component
 * @description: Util para conversão e otimização
 * @author: Dev. Weslley Lima
 * @version: V1
 */

@Component
public class ContaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ContaInputDTO converterInputDTOParaModel(Conta conta){
        return modelMapper.map(conta, ContaInputDTO.class);
    }

    public ContaOutputDTO converterModelParaOutputDTO(Conta conta) {
        return modelMapper.map(conta, ContaOutputDTO.class);
    }

    public Conta converterInputDTOParaModel(ContaInputDTO contaInputDTO) {
        return modelMapper.map(contaInputDTO, Conta.class);
    }
}