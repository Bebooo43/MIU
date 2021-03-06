package lab3_3A;

public class Main {

	public static void main(String[] args) {
		
		Circle circle = new Circle(5);
		circle.setHeight(10);//here we are changing the circle behavior
		System.out.println("The height of the circle is: "+circle.getHeight());
		System.out.println("The area of the circle is: "+circle.computeArea());

	}

}
