package com.jwl.memo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jwl.memo.common.FileManagerService;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{
	//설정
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// 그 뒤에는 경로 따라오는대로 그대로
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///" + FileManagerService.fileUploadPath + "/");
		
	}
}

