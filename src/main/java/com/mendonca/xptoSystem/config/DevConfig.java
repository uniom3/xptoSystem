package com.mendonca.xptoSystem.config;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mendonca.xptoSystem.service.CidadesService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private CidadesService service;
	
	@Bean
	public void instantiateDatabase() throws ParseException, IOException {
		 service.readerInsert();
}
		
	
	
}