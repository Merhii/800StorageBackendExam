package com.example._BackendExam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.800BackendExam")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
