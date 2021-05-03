package cs544.exercise17_1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	private SessionFactory sf;

	public void init(FilterConfig config) throws ServletException {
		
		ServletContext context = config.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
		sf = applicationContext.getBean("sessionFactory", SessionFactory.class);
										 
		Session session = sf.openSession();
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		Student student = new Student(11334, "Frank", "Brown");
		student.addCourse(course1);
		student.addCourse(course2);
		
		Transaction tx = session.beginTransaction();
		session.persist(student);
		tx.commit();
		session.close();
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {		
		Transaction tx = null;
		try {
			//tx = sf.getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			//tx.commit();
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

	public void destroy() {}
}
