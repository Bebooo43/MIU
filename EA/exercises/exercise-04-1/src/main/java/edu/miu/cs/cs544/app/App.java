package edu.miu.cs.cs544.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.miu.cs.cs544.examples.HibernateUtils;
import edu.miu.cs.cs544.lab4_1_a.Laptop;
import edu.miu.cs.cs544.lab4_1_a.Student;
import edu.miu.cs.cs544.lab4_1_b.Flight;
import edu.miu.cs.cs544.lab4_1_b.Passenger;
import edu.miu.cs.cs544.lab4_1_c.School;

public class App {

	private static final SessionFactory sessionFactory;
	private Transaction tx;
	
	static {
		// If there is more than one entity, you will have to pass them as a comma delimited argument list to the method below
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
				Laptop.class,Student.class, Flight.class, Passenger.class, School.class,
				edu.miu.cs.cs544.lab4_1_c.Student.class
		));
	}
	
	public static void main(String[] args) {
		App app = new App();
		//A
		Student student1 = new Student("FName", "LName", "Laptop Brand","Laptop Type");
		app.persist(student1);
		
		//B
		Flight flight = new Flight(123, "Brazil", "USA", LocalDate.of(2021, 1, 25));
		Passenger passenger = new Passenger("Passenger", flight);
		passenger.addFlight(new Flight(1234, "aaaaaa", "aaaaaa", null));
		app.persist(passenger);
		
		//C
		edu.miu.cs.cs544.lab4_1_c.Student student2 = new edu.miu.cs.cs544.lab4_1_c.Student(12345, "Student name", "Student Last Name");
		School school = new School("MIU", student2);
		app.persist(school);
		
		System.out.println("\n-------- Print Student Question A -------");
		app.print(student1);
		System.out.println("\n-------- Print Passenger Question B -------");
		app.print(passenger);
		System.out.println("\n-------- Print School Question C -------");
		app.print(school);
	}
	
	
	public void persist(Object obj) {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.persist(obj);
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
