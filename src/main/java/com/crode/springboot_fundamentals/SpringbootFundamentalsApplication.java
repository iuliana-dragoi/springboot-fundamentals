package com.crode.springboot_fundamentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootFundamentalsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootFundamentalsApplication.class, args);
		displayBeans(applicationContext);
	}

	private static void displayBeans(ConfigurableApplicationContext applicationContext) {
		String[] beans = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for(String bean : beans) {
			System.out.println(" -> " + bean);
		}
	}
}
