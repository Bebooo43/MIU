package cs544.exercise17_1;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentService {
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Student getStudent(long studentid) {
		return studentDAO.load(studentid);
	}
	
	
}
