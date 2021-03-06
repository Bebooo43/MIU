package lab9.question_12;

import java.util.Optional;

public class MySingletonLazy {

	private static MySingletonLazy instance = null;
	
	private MySingletonLazy() {}
	
	public static MySingletonLazy getInstance() {
		return Optional.ofNullable(instance).orElseGet(() -> new MySingletonLazy());
	}
}
