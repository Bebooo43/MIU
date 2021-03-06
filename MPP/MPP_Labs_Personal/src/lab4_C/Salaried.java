package lab4_C;

public class Salaried extends Employee{

	private Double salary;
	
	public Salaried() {}
	
	public Salaried(long id,double salary) {
		this.setEmployeeId(id);
		this.salary = salary;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public Double calcGrossPayment(int month, int year) {
		return salary;
	}
}
