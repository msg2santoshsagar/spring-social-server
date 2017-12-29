package com.sagar.springsocialserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sagar.springsocialserver.domain.constants.AppConstant;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.sagar.springsocialserver.controller"))
				.build()
				.apiInfo(getMetaData());	
	}
	
	
	private ApiInfo getMetaData() {
		return new ApiInfo("Spring Social Api Documentation",
				"Spring Social Service Api Documentation", 
				AppConstant.APP_VERSION,
				"http://localhost:8080/",
				new Contact("Santosh Sagar", "http://localhost:8080/", "msg2santoshsagar@gmail.com"), 
				"MIT", "http://localhost:8080");
	}

}
