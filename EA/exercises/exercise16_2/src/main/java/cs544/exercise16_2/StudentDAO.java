package cs544.exercise16_2;

import org.hibernate.SessionFactory;

public class StudentDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public StudentDAO() {}

	public Student load(long studentid) {
		System.out.println("Session in load dao:"+sf.getCurrentSession());
		Student student = sf.getCurrentSession().createQuery("from Student where id = :id",Student.class).setParameter("id", studentid).uniqueResult();	
		return student;
	}
}
