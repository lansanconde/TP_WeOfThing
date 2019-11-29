package com.lansanalatty.wot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lansanalatty.wot.jena.JenaRDF;

@SpringBootApplication
public class WebOfThingApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(WebOfThingApplication.class, args);
	}
}
