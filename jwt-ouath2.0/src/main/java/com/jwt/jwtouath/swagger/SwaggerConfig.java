package com.jwt.jwtouath.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@EnableWebMvc
@ComponentScan("Scan_Package_Name")
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerApi() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info()
						.title("스프링시큐리티 + JWT 예제")
						.description("스프링시큐리티와 JWT를 이용한 사용자 인증 예제입니다.")
						.version("1.0.0"));
	}
}
