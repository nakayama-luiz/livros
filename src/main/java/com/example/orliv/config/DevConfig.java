package com.example.orliv.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevConfig implements ConfigMaster{
    @Override
    public void run() {
        System.out.println("estou em ambiente de dev.");
    }
}
