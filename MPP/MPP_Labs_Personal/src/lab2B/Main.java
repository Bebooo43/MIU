package lab2B;

public class Main {

	public static void main(String[] args) {

		Order order = new Order();
		System.out.println(order.toString());
		
		OrderLine orderLine = new OrderLine(order);
		System.out.println(orderLine.toString());
		
		System.out.println(order.getOrderLines().size());

	}

}
