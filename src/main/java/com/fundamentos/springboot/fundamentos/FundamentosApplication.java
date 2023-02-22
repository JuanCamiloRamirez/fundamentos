package com.fundamentos.springboot.fundamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;

@SpringBootApplication
public class FundamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);

		System.out.println("hellow");
	}

}
