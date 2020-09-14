package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3196957746800697921L;

	private String orderId;
	
	private String orderName;
	
	private BigDecimal orderPrice;
	
	private Date orderCreateTime;
	
	private Date paymentDate;
	
	private BigDecimal paymentPrice;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(BigDecimal paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", orderName=" + orderName + ", orderPrice=" + orderPrice
				+ ", orderCreateTime=" + orderCreateTime + ", paymentDate=" + paymentDate + ", paymentPrice="
				+ paymentPrice + "]";
	}
}
