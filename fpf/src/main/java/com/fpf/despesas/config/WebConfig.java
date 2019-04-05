package com.fpf.despesas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fpf.despesas.storage.AnexoStorage;
import com.fpf.despesas.storage.local.AnexoStorageLocal;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	
	@Bean
	public AnexoStorage anexoStorage() {
		return new AnexoStorageLocal();
	}
	
}
