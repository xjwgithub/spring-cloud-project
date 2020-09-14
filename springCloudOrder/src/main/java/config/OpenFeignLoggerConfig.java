package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Logger.Level;

@Configuration
public class OpenFeignLoggerConfig {
	
	@Bean
	public Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
