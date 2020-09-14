package springCloudGetaway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyCheckGateWayFilter implements GlobalFilter,Ordered{
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String username = exchange.getRequest().getQueryParams().getFirst("username");
		if(null==username) {
			System.out.println("非法用户！");
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}
	
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
}
