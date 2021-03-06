package finalExam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {
		Stream<List<String>> st = Stream.of(new ArrayList<>(Arrays.asList("a")),new ArrayList<>(Arrays.asList("b")),new ArrayList<>(Arrays.asList("c")),new ArrayList<>(Arrays.asList("d")));
//		st.flatMap(l -> l.stream()).forEach(System.out::print);
	
		List<String> flatMapList = st.flatMap(pList -> pList.stream()).collect(Collectors.toList());
		System.out.println(flatMapList);
		
		
		Integer sum2 = Arrays.asList(1,2,3).stream ().reduce(0, (x, y) -> x + y);
		System.out.println(sum2);
		
		String result = flatMapList.stream().collect(Collectors.joining());
		System.out.println(result);
				
		Stream.concat(flatMapList.stream(),flatMapList.stream()).forEach(System.out::print);
		
		System.out.println();
		IntStream.range(1, 100).forEach(System.out::print);
		System.out.println();
		IntStream.rangeClosed(1, 100).forEach(System.out::print);
		System.out.println();
		System.out.println(LambdaLibrary.CONTAINS_L.apply("OlL"));
		
		//flatMapList.stream().collect(Collectors.toList()).forEach(System.out::print);
		//flatMapList.stream().collect(Collectors.toList()).forEach(System.out::print);

		List<?> ints = new ArrayList<>(Arrays.asList("a","a"));
		
		System.out.println(ints.get(0));

		int[] ints2 = new int[] {1,2,3,4,5};
		System.out.println(Arrays.stream(ints2).reduce(1, (a,b) -> a*b));
		
		System.out.println(Arrays.stream(ints2).toArray());

		
		Function f;
		Predicate p;
		
		Student st2 = null;new Student("ddd", "grade", LocalDate.of(1992, 2, 23));
		
		
	}
	
	public static int sumOfSquare(int i) {
		return IntStream.iterate(1,n->n+1).map(n->n*n).limit(i).sum();
	}

}
