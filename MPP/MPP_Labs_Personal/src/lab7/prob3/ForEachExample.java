package lab7.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		
		List<String> listInt = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		ForEachExample myClass = new ForEachExample();
		MyConsumer consumer = myClass.new MyConsumer();
		//print each element of the list in upper case format
		
		
		int sum = 0;
		
		BiFunction<Integer,Integer,Integer> b;
		
	}
	
	//implement a Consumer
	class MyConsumer implements Consumer<String>{

		@Override
		public void accept(String t) {
			System.out.println(t.toUpperCase());
		}
		
	}
	
}