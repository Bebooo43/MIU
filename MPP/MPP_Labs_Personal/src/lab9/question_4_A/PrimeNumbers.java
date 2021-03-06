package lab9.question_4_A;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		//TODO without filter and map 
		final Stream<Integer> primes = Stream.iterate(2, n -> primeNumbers(n++) ? n : null); 
		System.out.println(primes.limit(2).collect(Collectors.toList()));	
	}
	
	public static boolean primeNumbers(int n) {
		return IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
	}
}
