package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//SpringBoot∆Ù∂Ø¿‡
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudOrderConsulApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderConsulApp.class, args);
	}
}
