package springCloudOrderHystrix.service;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallbackImpl implements OrderService{
	@Override
	public void getOrderInfoOk() {
		System.out.println("OpenFeignOK异常！");
		
	}
	
	@Override
	public void getOrderInfoTimeOut() {
		System.out.println("defultFallbackMethod异常！");
		
	}
	
	@Override
	public void getOrderInfoError(String abc) {
		System.out.println("defultFallbackMethod异常！");
		
	}
	
	public void defultFallbackMethod() {
		System.out.println("defultFallbackMethod异常！");
	}
}
