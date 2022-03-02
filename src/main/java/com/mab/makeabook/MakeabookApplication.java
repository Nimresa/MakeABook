package com.mab.makeabook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MakeabookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeabookApplication.class, args);
	}
	@GetMapping("/error")
	public String error(){
		return "error";
	}
}
