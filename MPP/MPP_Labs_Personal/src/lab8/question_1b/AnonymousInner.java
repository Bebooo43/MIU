package lab8.question_1b;

import java.util.function.Supplier;

public class AnonymousInner {

	public static void main(String[] args) {
		System.out.println(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		}.get());
	}

}
