package com.harish.CredenCare;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	    exclude = {
	        org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration.class
	    }
	)
public class CredenCareApplication
{
	public static void main(String[] args) {
		SpringApplication.run(CredenCareApplication.class, args);
	}

}
