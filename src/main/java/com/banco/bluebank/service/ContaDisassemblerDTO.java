package com.banco.bluebank.service;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.dto.output.AgenciaOutputDTO;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;
import com.banco.bluebank.model.dto.output.CorrentistaOutputDTO;
import com.banco.bluebank.utils.DigitoVerificadorLuhn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContaDisassemblerDTO {

    @Autowired
    private DigitoVerificadorLuhn dv;

    public ContaOutputDTO toModelDTO(Conta conta){

        ContaOutputDTO contaDTO = new ContaOutputDTO();
        contaDTO.setNumeroConta(conta.getNumeroConta());
        contaDTO.setDigito(dv.calculaDigitoVerificador(conta.getNumeroConta().toString()));
        contaDTO.setNumeroContaCompleta(String.format("%s-%s",contaDTO.getNumeroConta().toString(),contaDTO.getDigito()));
        contaDTO.setTipoConta(conta.getTipoConta());
        contaDTO.setDataCadastro(conta.getDataCadastro());

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

    public Page<ContaOutputDTO> toCollectionModelDTO(Page<Conta> contas){
       List<ContaOutputDTO> contasAux = contas.stream()
                .map(conta -> toModelDTO(conta))
                .collect(Collectors.toList());
       Page<ContaOutputDTO> page = new PageImpl<>(contasAux);
       return page;
    }

}
