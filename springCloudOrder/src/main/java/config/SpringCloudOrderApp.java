package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import loadbalanceConfig.myRuler;

@SpringBootApplication(scanBasePackages = {"config","controller","service"})
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = myRuler.class)
@EnableFeignClients(basePackages = {"service"})
public class SpringCloudOrderApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderApp.class, args);
	}
	
}
