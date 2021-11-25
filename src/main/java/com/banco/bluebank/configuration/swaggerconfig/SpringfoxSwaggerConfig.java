package com.banco.bluebank.configuration.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
/**
 * @name: SpringfoxSwaggerConfig
 * @categoria: Configuração
 * @description: Util para documentção
 * @author: Dev. Weslley Lima
 * @version: V1
 */
@Configuration
@EnableSwagger2
public class SpringfoxSwaggerConfig {

    @Bean
    public Docket aDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.banco.bluebank"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(moreInfo());

    }

    private ApiInfo moreInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "AULA SOBRE API Application Programming Interface C/ SPRING BOOT BANCO PAN!",
                "DEVE-SE INFORMAR OBJETIVOS DESSA API",
                "DEVE-SE INFORMAR VERSÃO",
                "DEVE-SE COLOCAR TERMO DE SERVIÇO - SUGESTÃO - PODEMOS COLOCAR UM DOC EM HTML EXPLICANDO O TERMO-" +
                        "NÃO SERIA FRONT-END",
                new Contact("SQUAD-7-FIVEDEV", "https://WWW.NOMOMENTOQUEESTIVERNAAWS",
                        "faleconosco@bluebank.com.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
        return apiInfo;
    }
}
