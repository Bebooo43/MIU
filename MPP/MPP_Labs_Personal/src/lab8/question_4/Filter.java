package lab8.question_4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Filter filter = new Filter();
		List<String> list = Arrays.asList("john","mary","oaks","thomas","kevin");
		System.out.println(filter.countWords(list, 'o', 'y', 4)); 
	}
	
	
	
	
	public int countWords(List<String> words, char c, char d, int len) {
		
		//use as a Function<>
			
		  return (int)words.stream()   //convert list to stream
  	     .filter(word -> contains(word, c) && !contains(word, d) && word.length() == len) //returns filtered stream
  	     .count();
	}
	
	public boolean contains(String word, char c) {
		for (int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == c)
				return true;
		}
		return false;
	}

}
