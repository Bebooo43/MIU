package lab9.question_4_B;

import java.math.BigInteger;
import java.util.stream.Stream;

public class PrimeStream {

	public static void main(String[] args) {
		PrimeStream ps = new PrimeStream(); //PrimeStream is enclosing class
		ps.printFirstNPrimes(10);
		System.out.println("\n============================================");
		ps.printFirstNPrimes(5);
	}

	private void printFirstNPrimes(int limit) {
		  Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime)
          .limit(limit)
          .forEach(x -> System.out.format("%s ", x));
	}
}
