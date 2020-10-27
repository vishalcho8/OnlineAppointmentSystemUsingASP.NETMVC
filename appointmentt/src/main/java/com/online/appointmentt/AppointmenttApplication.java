package com.online.appointmentt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class AppointmenttApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppointmenttApplication.class, args);			    
	}

}
