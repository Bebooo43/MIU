package finalExam;

import java.time.LocalDate;

public class Student {

	private String name;
	private String cgpa;
	private LocalDate dateOfAdmission;
	
	public Student(String name, String cgpa, LocalDate dateOfAdmission) {
		super();
		this.name = name;
		this.cgpa = cgpa;
		this.dateOfAdmission = dateOfAdmission;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cgpa == null) ? 0 : cgpa.hashCode());
		result = prime * result + ((dateOfAdmission == null) ? 0 : dateOfAdmission.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Student other = (Student) obj;
		if (cgpa == null) {
			if (other.cgpa != null)
				return false;
		} else if (!cgpa.equals(other.cgpa))
			return false;
		if (dateOfAdmission == null) {
			if (other.dateOfAdmission != null)
				return false;
		} else if (!dateOfAdmission.equals(other.dateOfAdmission))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	
	
}
