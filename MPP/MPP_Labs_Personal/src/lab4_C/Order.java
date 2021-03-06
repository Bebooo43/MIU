package lab4_C;

import java.time.LocalDate;

public class Order {

	private Long orderNo;
	private LocalDate orderDate;
	private Double orderAmount;
	private Commissioned commissioned;
	
	public Order(Commissioned commissioned) {
		this.commissioned = commissioned; 
	}
	
	public Order(long orderNo, LocalDate orderDate, double orderAmount, Commissioned commissioned) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.commissioned = commissioned;
	}
	
	public Commissioned getCommissioned() {
		return commissioned;
	}
	public void setCommissioned(Commissioned commissioned) {
		this.commissioned = commissioned;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
}
