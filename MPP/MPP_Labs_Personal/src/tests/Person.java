package tests;

import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Person {

	private String name;
	
	public Person(String name) {
		this.name = name;// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}


	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Person)) return false;
		Person p = (Person)obj;
		return p.name.equals(this.name);
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("John");
		Person p2 = new Person("Jhanny");
		
		HashMap<Person, String> map = new HashMap<Person, String>();
		map.put(p1, p1.name);
		map.put(p2, p2.name);
		
		System.out.println(map.values());
		
		Stream<String> s = Stream.generate(() -> "Echo");
		Stream<Integer> i = Stream.iterate(1, n->n+2).skip(4);
		System.out.println((i.limit(4).collect(Collectors.toList())));
		
	}

}
