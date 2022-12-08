package com.etiya.ecommercedemopair7;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceDemoPair7Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(ECommerceDemoPair7Application.class, args);
        for (String applicationName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(applicationName);
        }
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
