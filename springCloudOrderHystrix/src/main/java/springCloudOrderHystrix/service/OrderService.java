package springCloudOrderHystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-HYSTR", fallback = OrderServiceFallbackImpl.class)
public interface OrderService {
	
	@GetMapping(value = "/getPaymentInfoOk")
	public void getOrderInfoOk();
	
	@GetMapping(value = "/getPaymentInfoTimeOut")
	public void getOrderInfoTimeOut();
	
	@GetMapping(value = "/getPaymentInfoError")
	public void getOrderInfoError(@RequestParam("abc")String abc);
}
