package com.app.Medicaments;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MedicamentsApplication {

	@Bean
	public ModelMapper modelMapper (){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(MedicamentsApplication.class, args);
	}

}
