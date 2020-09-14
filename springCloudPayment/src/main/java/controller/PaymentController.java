package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entity.OrderEntity;
import service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value = "/getOrderInfoOpenFeign")
	public ResponseEntity<OrderEntity> getPaymentInfoByOpenFeign(String orderId,HttpServletRequest request) {
		OrderEntity orderInfo = paymentService.getPaymentInfo(orderId, request);
		ResponseEntity re = new ResponseEntity<OrderEntity>(orderInfo,HttpStatus.ACCEPTED);
		return re;
	}
	
	@GetMapping(value = "/getOrderInfoRestTemplate")
	public ResponseEntity<OrderEntity> getPaymentInfoByRestTemplate(String orderId,HttpServletRequest request) {
		OrderEntity orderInfo = paymentService.getPaymentInfoByRestTempalte(orderId, request);
		ResponseEntity re = new ResponseEntity<OrderEntity>(orderInfo,HttpStatus.ACCEPTED);
		return re;
	}
	
	@RequestMapping(value = "/savePayment",method = RequestMethod.POST)
	public String savePayment(String orderId,String paymentPrice,HttpServletRequest request) {
		HttpSession session = request.getSession();
		OrderEntity entity = paymentService.savePaymentInfo(orderId, paymentPrice);
		session.setAttribute(entity.getOrderId(), entity);
		System.out.println(entity);
		return "Ok";
	}
	
	@GetMapping(value = "/getPaymentInfo")
	public String getPaymentInfo() {
		
		return "port=8002---->getPaymentInfo!";
	}
}
