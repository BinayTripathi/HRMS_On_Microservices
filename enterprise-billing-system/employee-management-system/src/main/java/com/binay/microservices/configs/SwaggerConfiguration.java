package com.binay.microservices.configs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	
	/*Copied from ApiInfo class*/
	public static final Contact DEFAULT_CONTACT = new Contact("Binay", "www.linkedin.com/in/binay-tripathi-65938b20", "binay.mckv@gmail.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Employee-Management-System-On-Cloud", "Employee-Management-System Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	  
	static String[] producerConsumer = new String[] {"Application/Json" , "Application/XML"}; 
	//Set<String> DEFAULT_PRODUCER_CONSUMER = new HashSet<String>(Arrays.asList(producerConsumer));
	
	
	

	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO);
				/*.produces(DEFAULT_PRODUCER_CONSUMER)
				.consumes(DEFAULT_PRODUCER_CONSUMER);*/

	}
}