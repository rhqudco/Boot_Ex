package com.ai.ex.naver_ai_platform.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///Users/gobyeongchae/Desktop/");
		registry.addResourceHandler("objimages/**")
				.addResourceLocations("file:///Users/gobyeongchae/Desktop/images/");
		registry.addResourceHandler("voice/**")
				.addResourceLocations("file:///Users/gobyeongchae/Desktop/voice/");
	}
}