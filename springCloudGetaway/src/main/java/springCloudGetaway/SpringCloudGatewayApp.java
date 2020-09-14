package springCloudGetaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGatewayApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApp.class, args);
	}
}
