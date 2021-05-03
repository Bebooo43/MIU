package edu.miu.cs.cs544.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.miu.cs.cs544.examples.HibernateUtils;
import edu.miu.cs.cs544.lab3_2_a.Department;
import edu.miu.cs.cs544.lab3_2_a.Employee;
import edu.miu.cs.cs544.lab3_2_b.Book;
import edu.miu.cs.cs544.lab3_2_b.Publisher;
import edu.miu.cs.cs544.lab3_2_c.Course;
import edu.miu.cs.cs544.lab3_2_c.Student;
import edu.miu.cs.cs544.lab3_2_d.Customer;
import edu.miu.cs.cs544.lab3_2_d.Reservation;
import edu.miu.cs.cs544.lab3_2_f.Office;

public class App {

	private static final SessionFactory sessionFactory;
	private Transaction tx;
	
	static {
		// If there is more than one entity, you will have to pass them as a comma delimited argument list to the method below
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
				Department.class, Employee.class,
				Book.class, Publisher.class,
				Course.class, Student.class,
				Customer.class, Reservation.class,
				edu.miu.cs.cs544.lab3_2_e.Book.class, edu.miu.cs.cs544.lab3_2_e.Customer.class, edu.miu.cs.cs544.lab3_2_e.Reservation.class,
				edu.miu.cs.cs544.lab3_2_f.Department.class, edu.miu.cs.cs544.lab3_2_f.Employee.class,edu.miu.cs.cs544.lab3_2_f.Office.class
		));
	}
	
	public static void main(String[] args) {
		App app = new App();
		
		//A
		Department department = new Department("TI");
		Employee employee = new Employee("John", 123, department);
		app.persist(department);
		app.persist(employee);
	
		//B
		edu.miu.cs.cs544.lab3_2_b.Book book1 = new edu.miu.cs.cs544.lab3_2_b.Book(123, "Title", "Author");
		edu.miu.cs.cs544.lab3_2_b.Publisher publisher1 = new edu.miu.cs.cs544.lab3_2_b.Publisher("publisher 1");
		book1.setPublisher(publisher1);
		app.persist(publisher1);
		app.persist(book1);
		
		//C
		Course course = new Course(123, "BTI");
		Student student = new Student(612344, "John", "Santiago");
		student.addCourse(course);
		course.addStudent(student);
		app.persist(course);
		
		//D
		Customer customer = new Customer("Customer");
		Reservation reservation = new Reservation(LocalDate.of(2000, 2, 3));
		customer.addReservation(reservation);
		app.persist(customer);
		
		//E
		edu.miu.cs.cs544.lab3_2_e.Customer customer_e = new edu.miu.cs.cs544.lab3_2_e.Customer("Customer E");
		edu.miu.cs.cs544.lab3_2_e.Book book_e = new edu.miu.cs.cs544.lab3_2_e.Book(123, "Title", "Author");
		edu.miu.cs.cs544.lab3_2_e.Reservation reservation_e = new edu.miu.cs.cs544.lab3_2_e.Reservation(LocalDate.of(2021, 3, 30), book_e);
		app.persist(book_e);
		customer_e.addReservation(reservation_e);
		app.persist(customer_e);
		
		//F
		edu.miu.cs.cs544.lab3_2_f.Department department_f = new edu.miu.cs.cs544.lab3_2_f.Department("DP F");
		Office office = new Office(123, "Office Max");
		edu.miu.cs.cs544.lab3_2_f.Employee employee_f = new edu.miu.cs.cs544.lab3_2_f.Employee("Employee name", 123, department_f, office);
		department_f.addEmployee(employee_f);
		app.saveOrUpdate(office);
		app.saveOrUpdate(department_f);
		
	}
	
	//used because we are using cascade persist, so when we have the same owner detached obj problem may occur 
	public void persist(Object obj) {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.persist(obj);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void saveOrUpdate(Object obj) {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void print(Object obj) {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			List<Object> list = session.createQuery("from "+obj.getClass().getSimpleName(), Object.class).list();
			list.forEach(o -> System.out.println(o));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
