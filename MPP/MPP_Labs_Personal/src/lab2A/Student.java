package lab2A;

public class Student {

	private String name;
	private GradeReport report;
	
	public Student() {
		report = new GradeReport(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GradeReport getReport() {
		return report;
	}
	public void setReport(GradeReport report) {
		this.report = report;
	}
	
	
}
