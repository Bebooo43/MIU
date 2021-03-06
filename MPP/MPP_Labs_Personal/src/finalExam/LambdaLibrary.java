package finalExam;

import java.util.List;
import java.util.function.Function;

public class LambdaLibrary {
	
	public final static Function<String, Boolean> CONTAINS_L = 
			(string) -> string.contains("L");

}
