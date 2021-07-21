package com.edersonferreira.msperson.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .useDefaultResponseMessages(false)
          .globalResponses(HttpMethod.POST,responseMessageForPOST())
          .globalResponses(HttpMethod.GET,responseMessageForGET())
          ;
    }
	
	private List<Response> responseMessageForPOST()
	{
		List<Response> list = new ArrayList<>();
		list.add(new ResponseBuilder().code("500")
		        .description("Internal server error").build()
		);
		list.add(new ResponseBuilder().code("400")
		        .description("Bad request").build());
	    return list;
	}
	
	private List<Response> responseMessageForGET()
	{
		List<Response> list = new ArrayList<>();
		list.add(new ResponseBuilder().code("500")
		        .description("Internal server error").build()
		);
		list.add(new ResponseBuilder().code("404")
		        .description("Not found").build());
	    return list;
	}
	
}
