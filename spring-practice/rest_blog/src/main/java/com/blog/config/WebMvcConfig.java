package com.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	// application.yml 파일의 location 정보 가져오기
	@Value("${spring.upload.location}")
	private String uploadPath;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 어떤 경로로 들어오든 허락
		registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("OPTIONS", "GET", "POST",
				"PUT", "DELETE", "PATCH");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("file:" + uploadPath + "\\");
	}

}
