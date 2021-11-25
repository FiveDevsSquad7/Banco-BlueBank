package com.banco.bluebank.service;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.dto.output.AgenciaOutputDTO;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;

import com.banco.bluebank.model.dto.output.CorrentistaOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContaDisassemblerDTO {

    public ContaOutputDTO toModelDTO(Conta conta){

        ContaOutputDTO contaDTO = new ContaOutputDTO();
        contaDTO.setId(conta.getId());
        contaDTO.setNumeroConta(conta.getNumeroConta());
        contaDTO.setDigito(conta.getDigito());
        contaDTO.setTipoConta(conta.getTipoConta());

        CorrentistaOutputDTO correntistaDTO = new CorrentistaOutputDTO();
        correntistaDTO.setId(conta.getCorrentista().getId());
        correntistaDTO.setNome(conta.getCorrentista().getNome());
        correntistaDTO.setCpf(conta.getCorrentista().getCpf());
        correntistaDTO.setRg(conta.getCorrentista().getRg());
        correntistaDTO.setCnpj(conta.getCorrentista().getCnpj());

        contaDTO.setCorrentista(correntistaDTO);

        AgenciaOutputDTO agenciaDTO = new AgenciaOutputDTO();
        agenciaDTO.setId(conta.getAgencia().getId());
        agenciaDTO.setAgencia(conta.getAgencia().getAgencia());
        agenciaDTO.setNome(conta.getAgencia().getNome());

        contaDTO.setAgencia(agenciaDTO);

        return contaDTO;

    }

    public List<ContaOutputDTO> toCollectionModelDTO(List<Conta> contas){
        return contas.stream()
                .map(conta -> toModelDTO(conta))
                .collect(Collectors.toList());
    }

}
