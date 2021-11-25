package com.banco.bluebank.configuration.mapperconfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: ModelMapperConfig
 * @categoria: Configuração
 * @description: Util para dependency injection
 * @author: Dev. Weslley Lima
 * @version: V1
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
