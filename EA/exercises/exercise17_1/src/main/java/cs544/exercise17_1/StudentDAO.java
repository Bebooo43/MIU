package cs544.exercise17_1;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Transactional(propagation=Propagation.MANDATORY)
public class StudentDAO {

	private SessionFactory sf;
	
	public Student load(long studentid) {
		System.out.println("StudentDAO.load: "+sf.getCurrentSession());
		Student student = (Student) sf.getCurrentSession().createQuery("from Student s left join fetch s.courselist where s.id = :id").setParameter("id", studentid).uniqueResult();	
		return student;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
}
