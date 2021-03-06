package lab11.prob6;

public class Employee extends Person {
	int id;
	int salary;
	
	public Employee(int id, String n, int s) {
		super(n);
		this.id = id;
		this.salary = s;
		
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("name: ");
		sb.append(getName());
		sb.append(" salary: ");
		sb.append("" + salary);
		sb.append(" year of birth: ");
		return sb.toString();
		
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + salary;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	
	
	
}

