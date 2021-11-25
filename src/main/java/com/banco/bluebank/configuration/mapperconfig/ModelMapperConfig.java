package com.banco.bluebank.configuration.mapperconfig;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.addMappings()
//        modelMapper().createTypeMap(Conta.class, ContaOutputDTO.class)
//                .addMapping(Conta::getCorrentistaDTO, ContaOutputDTO::setCorrentista);

        return mapper;
    }
}
