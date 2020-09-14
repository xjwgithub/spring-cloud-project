package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import Entity.OrderEntity;
import service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	private static final String paymentUrl="http://cloud-payment-service";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/getOrderInfoOpenFeign")
	public String getOrderInfoOpenFeign(String orderId,HttpServletRequest request) {
//		OrderEntity orderInfo = orderService.getOrderInfo(orderId, request);
//		System.out.println(orderInfo);
//		ResponseEntity<OrderEntity> entity = restTemplate.getForEntity(paymentUrl+"/getPaymentInfo", OrderEntity.class);
		OrderEntity orderInfo = orderService.getOrderInfo();
		
		return null;
		
	}
	
	@GetMapping(value = "/getOrderInfoRestTemplate")
	public String getOrderInfoRestTemplate(String orderId,HttpServletRequest request) {
//		OrderEntity orderInfo = orderService.getOrderInfo(orderId, request);
//		System.out.println(orderInfo);
//		ResponseEntity<OrderEntity> entity = restTemplate.getForEntity(paymentUrl+"/getPaymentInfo", OrderEntity.class);
		ResponseEntity<OrderEntity> entity = restTemplate.getForEntity(paymentUrl+"/getOrderInfoRestTemplate", OrderEntity.class);
		System.out.println(entity);
		return null;
		
	}
	
	@GetMapping(value = "/saveOrder")
	public String saveOrder(String orderName,String orderPrice,HttpServletRequest request,HttpServletResponse response) {
		
//		try {
//			HttpSession session = request.getSession();
////			OrderEntity entity = orderService.saveOrder(orderName, orderPrice);
////			session.setAttribute(entity.getOrderId(), entity);
////			request.getRequestDispatcher(paymentUrl+"?orderId="+entity.getOrderId()+"&paymentPrice="+entity.getOrderPrice()).forward(request, response);
//			System.out.println("save finish");
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "Ok";
	}
}
