package com.ecommerce.backend.openapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${e-commerce.version}") String appVersion) {
		 return new OpenAPI()
//		      .components(new Components().addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
//		      .addParameters("myHeader1", new Parameter().in("header").schema(new StringSchema()).name("myHeader1")).addHeaders("myHeader2", new Header().description("myHeader2 header").schema(new StringSchema())))
		      .info(new Info()
		      .title("E-commerce API")
		      .version(appVersion)
		      .description("Il s'agit de la documentation de l'API REST d'un projet factice d'E-commerce. Le code source et un descriptif du projet sont disponibles [ici](https://github.com/VictoriaNiaba/e-commerce).")
		      .termsOfService("http://swagger.io/terms/")
		      .license(new License().name("Apache 2.0").url("https://github.com/VictoriaNiaba/e-commerce/blob/master/LICENSE.md")));
	}
}
