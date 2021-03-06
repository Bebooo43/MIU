package lab4_C;

import java.time.LocalDate;

public abstract class Employee {

	private Long employeeId;
	
	public void print() {
		LocalDate now = LocalDate.of(2018,1,1);
		PayCheck payCheck = calcCompensation(now.getMonthValue(), now.getYear());
		payCheck.print();
	}
	
	/**
	 *  •	FICA is 23%
		•	State tax is 5%
		•	Local tax is 1%
		•	Medicare is 3%
		•	Social Security is 7. 5%
	 * @return
	 */
	public PayCheck calcCompensation(int month, int year) {
		double grossPayment = calcGrossPayment(month, year);
		return new PayCheck(grossPayment,Tax.FICA, Tax.State, Tax.Local, Tax.Medicare, Tax.SocialSecurity);
	}
	
	public abstract Double calcGrossPayment(int month, int year);
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}
