package com.ai.ex.naver_ai_platform;

import com.ai.ex.naver_ai_platform.controller.APIController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ai.ex.naver_ai_platform.service"})
@ComponentScan(basePackageClasses = APIController.class)
public class NaverAiPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverAiPlatformApplication.class, args);
	}

}
