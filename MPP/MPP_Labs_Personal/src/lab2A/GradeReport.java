package lab2A;

public class GradeReport {

	private Student student;
	
	GradeReport(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
