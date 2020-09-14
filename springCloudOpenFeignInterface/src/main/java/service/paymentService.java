package service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface paymentService {
	
	@GetMapping("/getPaymentInfo")
	public String getPaymentInfo();
}
