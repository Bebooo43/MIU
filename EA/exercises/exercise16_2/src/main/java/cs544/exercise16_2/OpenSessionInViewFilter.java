package cs544.exercise16_2;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	private SessionFactory sf;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
		
		Transaction tx = null;
		try {
			System.out.println("doFilter Session:"+sf.getCurrentSession());
			tx = sf.getCurrentSession().beginTransaction();
			System.out.println("receiving request");
			chain.doFilter(request, response);
			System.out.println("sending response");
			tx.commit();
		 } catch(RuntimeException ex) {
			try {
				ex.printStackTrace();
				tx.rollback();
			 } catch(RuntimeException rbEx) {
				System.out.println("Could not rollback transaction " + rbEx);
				rbEx.printStackTrace();
			 }
			 throw ex;
		 }
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
		sf = HibernateUtil.getSessionFactory();
		System.out.println("doFilter init Session:"+sf.getCurrentSession());
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		//sf.getCurrentSession().persist(course1);
		//sf.getCurrentSession().persist(course2);
		
		sf.getCurrentSession().beginTransaction();
		Student student = new Student(11334, "Frank", "Brown");
		student.addCourse(course1);
		student.addCourse(course2);
		sf.getCurrentSession().persist(student);
		sf.getCurrentSession().getTransaction().commit();
	}
}
