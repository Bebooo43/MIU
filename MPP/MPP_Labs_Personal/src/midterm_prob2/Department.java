package midterm_prob2;

public abstract class Department {
	private StringQueue queue = new StringQueue();
	
	public StringQueue getQueue() {
		return queue;
	}
	//implement
	public abstract String getName();
	
	public String addMessage(String name) {
		getQueue().enqueue(name);
		return name;
	}
	
	public String nextMessage() {
		try {
			return queue.dequeue();
		} catch (EmptyQueueException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
