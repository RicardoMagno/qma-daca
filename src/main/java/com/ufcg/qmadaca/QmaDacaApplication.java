package com.ufcg.qmadaca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.ufcg.qmadaca"})
public class QmaDacaApplication {

	public static void main(String[] args) {
		SpringApplication.run(QmaDacaApplication.class, args);
	}
}
