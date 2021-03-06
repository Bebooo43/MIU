package lab9.question_10;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Or {

	public static void main(String[] args) {
		//Question 10A
		List<Simple> list = Arrays.asList(new Simple(false), new Simple(false), new Simple(true));
		System.out.println(new Or().someSimpleIsTrue(list));
		
		//Question 10B
		Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
		System.out.println(Arrays.toString(stringStream.toArray()).replace("[", "").replace("]", ""));
		
		//Question 10C
		Supplier<Stream<Integer>> streamSupplier = () ->  Stream.of(1,2,3,4,5,6);
		System.out.println("Max: "+streamSupplier.get().max(Comparator.naturalOrder()).get());
		System.out.println("Min: "+streamSupplier.get().min(Comparator.naturalOrder()).get());
	}
	
	public boolean someSimpleIsTrue(List<Simple> list) {
		return list.stream().map(s -> s.flag).reduce(false, (x, y) -> x || y);
	}

}
