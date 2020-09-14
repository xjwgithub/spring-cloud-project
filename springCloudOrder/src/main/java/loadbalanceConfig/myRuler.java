package loadbalanceConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class myRuler {
	
	@Bean
	public IRule getLoadbalanceRuler() {
		System.out.println("加载Ribbon");
		 return new RandomRule();
	}
}
