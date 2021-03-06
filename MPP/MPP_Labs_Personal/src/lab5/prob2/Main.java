package lab5.prob2;

import java.util.List;

public class Main {
	    static float sum;
	public static void main(String[] args) {
		IShape s1 = new Circle(2);
		IShape s2 = new Rectangle(2, 3);
		IShape s3 = new Triangule(3, 4);
		
		List<IShape> shapes = List.of(s1,s2,s3);
		sum = 0;
		shapes.stream().forEach((s) ->{sum+=s.computeArea();});
		System.out.printf(String.format("Sum of Areas = %.2f",sum));
		

	}
}
