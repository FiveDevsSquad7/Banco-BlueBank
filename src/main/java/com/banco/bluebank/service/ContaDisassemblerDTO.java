package com.banco.bluebank.service;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContaDisassemblerDTO {

    @Autowired
    private ModelMapper modelMapper;

    public ContaOutputDTO toModelDTO(Conta conta){
        return modelMapper.map(conta, ContaOutputDTO.class);
    }

    public List<ContaOutputDTO> toCollectionModelDTO(List<Conta> contas){
        return contas.stream()
                .map(conta -> toModelDTO(conta))
                .collect(Collectors.toList());
    }

}