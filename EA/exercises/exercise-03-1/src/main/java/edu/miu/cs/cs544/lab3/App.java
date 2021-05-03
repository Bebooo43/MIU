package edu.miu.cs.cs544.lab3;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.miu.cs.cs544.examples.HibernateUtils;

public class App {

	private static final SessionFactory sessionFactory;
	private Transaction tx;
	
	static {
		// If there is more than one entity, you will have to pass them as a comma delimited argument list to the method below
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Car.class, Owner.class));
	}
	
	public static void main(String[] args) {
		App app = new App();
		Owner owner = new Owner("John Santiago", "1000 N. 4th St. Fairfield, IA");
		Owner owner2 = new Owner("Jennyfer Santiago", "1000 N. 4th St. Fairfield, IA");

		Car c1 = new Car("Ford", 2010, 15.000, owner);
		Car c2 = new Car("Honda", 2015, 19.000, owner2);
		
		app.saveOrUpdate(c1);
		app.saveOrUpdate(c2);
		app.printCars();
	}
	
	//used because we are using cascade persist, so when we have the same owner detached obj problem may occur 
	public void saveOrUpdate(Car car) {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.persist(car);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void printCars() {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			List<Car> carList = session.createQuery("from Car", Car.class).list();
			carList.forEach(c -> System.out.println(c));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
