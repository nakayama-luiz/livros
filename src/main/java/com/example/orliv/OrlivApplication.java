package com.example.orliv;

import com.example.orliv.config.ConfigMaster;
import com.example.orliv.config.DevConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrlivApplication implements CommandLineRunner {


	@Autowired
	private ConfigMaster configMaster;


	public static void main(String[] args) {


        SpringApplication.run(OrlivApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		this.configMaster = new DevConfig();
		this.configMaster.run();
	}

}
