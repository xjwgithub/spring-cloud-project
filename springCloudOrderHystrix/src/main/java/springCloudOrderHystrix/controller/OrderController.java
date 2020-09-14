package springCloudOrderHystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import springCloudOrderHystrix.service.OrderService;

@Controller
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class OrderController {
	
	@Autowired
	private OrderService orderSerivce;
	
	@GetMapping(value="/getOrderInfoOk")
	public String getOrderInfoOk() {
		orderSerivce.getOrderInfoOk();
		return "OK";
	}
	
	@GetMapping("/getOrderInfoError")
	@HystrixCommand
	public String getOrderInfoError(String abc) {
		try {
			orderSerivce.getOrderInfoError(abc);
		}catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return "Error";
	}
	
	@GetMapping("/getOrderInfoTimeOut")
	@HystrixCommand(fallbackMethod = "getOrderInfoTimeOutFallback",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
	})
	public String getOrderInfoTimeOut() {
		orderSerivce.getOrderInfoTimeOut();
		return "TimeOut";
	}
	
	public String getOrderInfoTimeOutFallback() {
		System.out.println("消费端TimeOut Or Error");
		return "TimeOutFallback";
	}
	
	public String defaultFallbackMethod() {
		System.out.println("defaultFallbackMethodError!");
		return "defaultFallbackMethod!";
	}
}
