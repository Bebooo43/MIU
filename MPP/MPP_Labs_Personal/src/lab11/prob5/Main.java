package lab11.prob5;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> strings = List.of("A","B","C","D");
		List<Integer> integers = List.of(1,2,3,4);
		List<Double> doubles = List.of(1.0,2.0,3.0,4.0);
		
		System.out.println(secondSmallest(strings));
		System.out.println(secondSmallest(integers));
		System.out.println(secondSmallest(doubles));
	}

	public static Object secondSmallest(List<?> list) {
		return secondSmallestHelper(list);
	}
	
	public static <T> T secondSmallestHelper(List<T> list){
		return list.stream().sorted().skip(list.size() > 1 ? 1 : 0).findFirst().get();
		
		//Teacher's solution - two references (smallest, secondSmallest) see code in sakai
	}
}
