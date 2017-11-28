package com.luisusr.demopruebas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemopruebasApplication extends SpringBootServletInitializer {

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemopruebasApplication.class);
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemopruebasApplication.class, args);
	}
}
