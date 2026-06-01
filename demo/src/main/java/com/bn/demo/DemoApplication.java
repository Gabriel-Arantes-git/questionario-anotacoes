package com.bn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//define essa classe comol uma inicializadora do padrao de framework conhecido como springboot e usar para acessar/compilar
//de maneira correspondente ao padrao do framework
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
