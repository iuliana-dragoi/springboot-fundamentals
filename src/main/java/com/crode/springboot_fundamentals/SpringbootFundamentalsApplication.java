package com.crode.springboot_fundamentals;

import com.crode.springboot_fundamentals.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringbootFundamentalsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootFundamentalsApplication.class, args);
		AppProperties appProperties = applicationContext.getBean(AppProperties.class);
		displayBeans(applicationContext, appProperties);
	}

	private static void displayBeans(ConfigurableApplicationContext applicationContext, AppProperties appProperties) {
		if(!appProperties.isDisplayBeans()) return;

		String[] beans = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for(String bean : beans) {
			System.out.println(" -> " + bean);
		}
	}
}
