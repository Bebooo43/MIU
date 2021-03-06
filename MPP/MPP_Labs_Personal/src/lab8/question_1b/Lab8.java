package lab8.question_1b;

import java.util.function.Supplier;

public class Lab8 {

	public static void main(String[] args) {
		//Q1 B ii
		Supplier<Double> random = Math::random;
		System.out.println(random.get().doubleValue());
		
		//Q1 B iii
		System.out.println(new Lab8().new MyMath().get());
	}

	class MyMath implements Supplier<Double>{
		@Override
		public Double get() {
			return Math.random();
		}
	}
}
