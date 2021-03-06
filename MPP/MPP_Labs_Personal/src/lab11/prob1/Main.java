package lab11.prob1;

public class Main {

	public static void main(String[] args) {
		
		//Generic subtyping is not covariant using ArrayList
		
		/*Question A
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		List<Number> nums = ints; <----------- no covariant
		nums.add(3.14);*/

		/*Question B 
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;
		nums.add(3);              <----------- compiler error (get and put rule)
		*/
	}

}
