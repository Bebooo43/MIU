package edu.miu.cs.cs544.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.miu.cs.cs544.examples.HibernateUtils;
import edu.miu.cs.cs544.lab5_1_a.Customer;
import edu.miu.cs.cs544.lab5_1_a.Order;
import edu.miu.cs.cs544.lab5_1_a.OrderLine;
import edu.miu.cs.cs544.lab5_1_a.Product;
import edu.miu.cs.cs544.lab5_1_b.Book;
import edu.miu.cs.cs544.lab5_1_b.CD;
import edu.miu.cs.cs544.lab5_1_b.DVD;

public class App {

	private static final SessionFactory sessionFactory;
	private Transaction tx;
	
	static {
		// If there is more than one entity, you will have to pass them as a comma delimited argument list to the method below
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
				Customer.class, Order.class, OrderLine.class, Product.class, CD.class, DVD.class, Book.class 
		));
	}
	
	public static void main(String[] args) {
		App app = new App();
		//Question A
		Customer customer = new Customer("First Name", "Last Name");
		Product product = new Product("My product", "Product Description");

		Order order = new Order(LocalDate.of(2021, 1, 30), customer);
		OrderLine orderLine = new OrderLine(10, product);
		
		order.addOrderLine(orderLine);
		customer.addOrder(order);
		
		//app.persist(product);
		//app.persist(customer);
		
		System.out.println("\n-------- Print Customer Question A -------");
		//app.print(customer);
		
		//Question B
		Product p1 = new Book("book name","book description","book title");
		Product p2 = new CD("cd name","cd description","artist");
		Product p3 = new DVD("dvd name","dvd description","genre");
		app.persist(p1);app.persist(p2);app.persist(p3);
		System.out.println("\n-------- Print Products Question B -------");
		app.printProducts();
		
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
			List<Object> list = session.createQuery("from "+obj.getClass().getSimpleName(),Object.class).list();
			list.forEach(o -> System.out.println(o));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void printProducts() {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			List<Product> list = session.createQuery("from Product",Product.class).list();
			list.forEach(o -> System.out.println(o));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
