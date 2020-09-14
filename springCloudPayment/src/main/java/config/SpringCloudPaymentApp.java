package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"config","controller","service"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"service"})
public class SpringCloudPaymentApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPaymentApp.class, args);
	}
}
