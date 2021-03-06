package lab2B;

import java.util.Arrays;
import java.util.List;

public class Order {
	private int ordemNum;
	private List<OrderLine> orderLines;
	
	public Order() {
		orderLines = Arrays.asList(new OrderLine(this));
	}
	
	public int getOrdemNum() {
		return ordemNum;
	}
	public void setOrdemNum(int ordemNum) {
		this.ordemNum = ordemNum;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
}
