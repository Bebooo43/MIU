package lab8.question_3;

import java.util.function.BiFunction;

public class BiFunctionExample {

	public static void main(String[] args) {

		BiFunction<Double, Double, Double> biFuntion = Math::pow;
		System.out.println(biFuntion.apply(2.0, 3.0));
	}

}
