package com.etiya.ecommercedemopair7;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceDemoPair7Application {

    public static void main(String[] args) {

        SpringApplication.run(ECommerceDemoPair7Application.class, args);

    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
