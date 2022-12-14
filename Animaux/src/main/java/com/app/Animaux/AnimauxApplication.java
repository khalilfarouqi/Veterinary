package com.app.Animaux;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimauxApplication {

	@Bean
	public ModelMapper modelMapper (){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(AnimauxApplication.class, args);
	}

}
