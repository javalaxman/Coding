package com.iiht.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.iiht.*"})
public class DemoProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoProject1Application.class, args);
	}
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
		
		
	}

}
