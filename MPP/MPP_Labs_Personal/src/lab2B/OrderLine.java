package lab2B;

public class OrderLine {
	private Order order;
	
	OrderLine(Order order) {
		this.order = order;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
