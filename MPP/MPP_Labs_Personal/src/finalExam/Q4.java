package finalExam;

import java.util.Optional;
import java.util.stream.IntStream;

public class Q4 {

	public static void main(String[] args) {

		System.out.println(sumFirstNSquares(5));
		
		
	}

	public static Integer sumFirstNSquares(int n) {
		 //return IntStream.iterate(1, c->c+1).map(x -> x*x).limit(n).sum();
		return IntStream.iterate(1, c->c+1).limit(n).map(t -> t*t).reduce(0, (x,y) -> x+y);
	}
}
