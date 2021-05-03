package cs544.lab2.exercise1;


import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class AppBook {

	private static SessionFactory sessionFactory;
	private Transaction transaction;
	
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public static void main(String[] args) {
		AppBook appBook = new AppBook();
		
		Book b1 = new Book("GoF", "1234ABC", "GoF authors", 10.0, LocalDate.of(2000, 10, 10));
		Book b2 = new Book("Weaving the Web", "567ABC", "Tim Beners-Lee", 12.0, LocalDate.of(2007, 6, 12));
		Book b3 = new Book("The Action's Power", "987ABC", "Febracis", 15.0, LocalDate.of(2010, 2, 15));
			
		saveOrUpdateBook(appBook.transaction,b1);
		saveOrUpdateBook(appBook.transaction,b2);
		saveOrUpdateBook(appBook.transaction,b3);
		printBooks(appBook.transaction);
		
		Book book1 = getBook(appBook.transaction, 1);
		Book book2 = loadBook(appBook.transaction, 2);
		
		book1.setTitle("Book 1 Changed");
		saveOrUpdateBook(appBook.transaction,book1);
		
		deleteBook(appBook.transaction,book2);
		printBooks(appBook.transaction);
	}


	private static void saveOrUpdateBook(Transaction transaction, Book book) {
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(book);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	private static void deleteBook(Transaction transaction, Book book) {
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.delete(book);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	private static Book getBook(Transaction transaction, int id) {
		Book book = null;
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			book = session.get(Book.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return book; 
	}

	private static Book loadBook(Transaction transaction, int id) {
		Book book = null;
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			book = session.load(Book.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return book; 
	}
	
	private static void printBooks(Transaction transaction) {
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			List<Book> bookList = session.createQuery("from Book", Book.class).list();
			bookList.forEach(b -> System.out.println(b));
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
