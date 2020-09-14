package config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplateBean() {
		RestTemplate rt = new RestTemplate();
		return rt;
	}
}
