package com.example.orliv.config;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdConfig implements ConfigMaster{
    @Override
    public void run() {

        System.out.println("estou em ambiente de prod.");
    }
}
