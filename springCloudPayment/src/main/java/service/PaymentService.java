package service;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import Entity.OrderEntity;

@Service
public class PaymentService {
	

	public OrderEntity getPaymentInfo(String orderId,HttpServletRequest request) {
		//模拟调用Dao层生成数据
		OrderEntity oe=  new OrderEntity();
		oe.setOrderId("8002----OpenFeign");
		oe.setOrderName("orderbalabala8002");
		oe.setOrderPrice(new BigDecimal(15));
		oe.setOrderCreateTime(new Date());
//		HttpSession session = request.getSession();
//		OrderEntity oe = (OrderEntity)session.getAttribute(orderId);
		System.out.println(oe);
		return oe;
	}
	
	public OrderEntity getPaymentInfoByRestTempalte(String orderId,HttpServletRequest request) {
		//模拟调用Dao层生成数据
		OrderEntity oe=  new OrderEntity();
		oe.setOrderId("8002----Template");
		oe.setOrderName("orderbalabala8002");
		oe.setOrderPrice(new BigDecimal(15));
		oe.setOrderCreateTime(new Date());
//		HttpSession session = request.getSession();
//		OrderEntity oe = (OrderEntity)session.getAttribute(orderId);
		System.out.println(oe);
		return oe;
	}
	
	public OrderEntity savePaymentInfo(String orderId,String paymentPrice) {
		OrderEntity oe=  new OrderEntity();
		oe.setOrderId(orderId);
		oe.setOrderName("orderpayment");
		oe.setPaymentPrice(new BigDecimal(paymentPrice));
		oe.setPaymentDate(new Date());
		return oe;
	}
}
