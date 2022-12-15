package com.etiya.ecommercedemopair7;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

@Configuration
public class SwaggerConfiguration {
    //Swagger'a tüm istekler için "Accept-Language" header alanı açmak istiyoruz.

    @Bean
    public OperationCustomizer customGlobalHeaders() {
        return (Operation operation, HandlerMethod handlerMethod) -> {
            Parameter headerParameter = new Parameter()
                    .in(ParameterIn.HEADER.toString())
                    .schema(new StringSchema())
                    .name("Accept-Language")
                    .description("Bu alan multi dil desteği getirilmesi adına kullanılmaktadır.")
                    .required(false);

            operation.addParametersItem(headerParameter);

            return operation;
        };
    }
}
