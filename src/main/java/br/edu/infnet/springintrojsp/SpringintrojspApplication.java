package br.edu.infnet.springintrojsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringintrojspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringintrojspApplication.class, args);
	}
}