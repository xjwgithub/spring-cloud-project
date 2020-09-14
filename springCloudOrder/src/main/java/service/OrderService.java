package service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import Entity.OrderEntity;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderService {
	
	@GetMapping(value = "/getOrderInfoOpenFeign")
	public OrderEntity getOrderInfo();
	
}
