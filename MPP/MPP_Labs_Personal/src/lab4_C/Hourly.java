package lab4_C;

public class Hourly extends Employee{
	
	private static final int WEEKS_PER_MONTH = 4;
	private Double hourlyWage;
	private Double hoursPerWeek;
	
	public Hourly() {}
	
	public Hourly(long id,double hourlyWage, double hoursPerWeek) {
		this.setEmployeeId(id);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}
	
	@Override
	public Double calcGrossPayment(int month, int year) {
		return hourlyWage * hoursPerWeek * WEEKS_PER_MONTH;
	}
	
	public Double getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(Double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	public Double getHoursPerWeek() {
		return hoursPerWeek;
	}
	public void setHoursPerWeek(Double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}	

}
