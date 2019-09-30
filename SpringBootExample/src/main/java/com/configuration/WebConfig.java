package com.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan(basePackages = {"com"})
public class WebConfig implements WebMvcConfigurer{
	


	@Bean
	@Description("Create new been modelmapper")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	/**
	 * 
	 *Method register home view 
	 *
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/").setViewName("home");
	}


}
