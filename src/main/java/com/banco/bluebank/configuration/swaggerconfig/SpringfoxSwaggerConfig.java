package com.banco.bluebank.configuration.swaggerconfig;

import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SpringfoxSwaggerConfig {

    @Bean
    public Docket aDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.banco.bluebank"))
                .paths(PathSelectors.any())
                .build().ignoredParameterTypes(OAuth2ResourceServerConfigurer.JwtConfigurer.class).globalOperationParameters(
                        Arrays.asList(new ParameterBuilder().name("Authorization")
                                .description("Header para token JWT")
                                .modelRef(new ModelRef("string")).parameterType("header")
                                .required(false).build())).select().build().securitySchemes
                        (Arrays.asList(new ApiKey("Token Access",
                                HttpHeaders.AUTHORIZATION, In.HEADER.name())))
                .apiInfo(moreInfo());

    }


    private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("500 message")
                    .responseModel(new ModelRef("Error"))
                    .build());
            add(new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden!")
                    .build());
        }};
    }

    private List<ResponseMessage> responseMessageForPUT()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("500 message")
                    .responseModel(new ModelRef("Error"))
                    .build());
            add(new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden!")
                    .build());
        }};
    }

    private List<ResponseMessage> responseMessageForPOST()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("500 message")
                    .responseModel(new ModelRef("Error"))
                    .build());
            add(new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden!")
                    .build());
        }};
    }

    private List<ResponseMessage> responseMessageForDELETE()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("500 message")
                    .responseModel(new ModelRef("Error"))
                    .build());
            add(new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden!")
                    .build());
        }};
    }

    private ApiInfo moreInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "AULA SOBRE API Application Programming Interface C/ SPRING BOOT BANCO PAN!",
                "DEVE-SE INFORMAR OBJETIVOS DESSA API",
                "DEVE-SE INFORMAR VERSÃO",
                "DEVE-SE COLOCAR TERMO DE SERVIÇO - SUGESTÃO - PODEMOS COLOCAR UM DOC EM HTML EXPLICANDO O TERMO-" +
                        "NÃO SERIA FRONT-END",
                new Contact("Squad 6Devs\n", "https://bluebank.6devs.com.br\n",
                        "faleconosco@bluebank.com.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
        return apiInfo;
    }
}
