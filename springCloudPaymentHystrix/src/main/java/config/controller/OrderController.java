package config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import config.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/getPaymentInfoOk")
	public String getPaymentInfoOk() {
		orderService.getPaymentInfoOk();
		return "OK";
	}
	
	@GetMapping(value = "/getPaymentInfoTimeOut")
	public String getPaymentInfoTimeOut() {
		orderService.getPaymentInfoTimeOut();
		return "timeOut";
	}
	
	@GetMapping(value = "/getPaymentInfoError")
	public String getPaymentInfoError(@RequestParam("abc")int abc) throws Exception {
		orderService.getPaymentInfoError(abc);
		return "error";
	}
}
