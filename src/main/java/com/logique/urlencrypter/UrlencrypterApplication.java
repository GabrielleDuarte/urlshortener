package com.logique.urlencrypter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class UrlencrypterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlencrypterApplication.class, args);
	}

}
