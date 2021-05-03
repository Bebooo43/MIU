package cs544.lab2.exercise2;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class AppPerson {

	private static SessionFactory sessionFactory;
	private Transaction transaction;
	
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public static void main(String[] args) {
		AppPerson appPerson = new AppPerson();
		
		Person p1 = new Person("John", "Santiago", LocalDate.of(1992, 03, 7));
		Person p2 = new Person("Jennyfer", "Santiago", LocalDate.of(1993, 04, 7));
		Person p3 = new Person("João", "Santiago", LocalDate.of(2000, 06, 27));
		
		saveOrUpdatePerson(appPerson.transaction,p1);
		saveOrUpdatePerson(appPerson.transaction,p2);
		saveOrUpdatePerson(appPerson.transaction,p3);
		printPeople(appPerson.transaction);
		
		Person person1 = getPerson(appPerson.transaction, 1);
		Person person2 = loadPerson(appPerson.transaction, 2);
		
		person1.setFirstname("Name Changed");
		saveOrUpdatePerson(appPerson.transaction,person1);
		
		deletePerson(appPerson.transaction,person2);
		printPeople(appPerson.transaction);

	}

	private static void saveOrUpdatePerson(Transaction transaction, Person person) {
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(person);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	private static void deletePerson(Transaction transaction, Person person) {
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.delete(person);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	private static Person getPerson(Transaction transaction, int id) {
		Person person = null;
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			person = session.get(Person.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return person; 
	}

	private static Person loadPerson(Transaction transaction, int id) {
		Person person = null;
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			person = session.load(Person.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return person; 
	}
	
	private static void printPeople(Transaction transaction) {
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			List<Person> personList = session.createQuery("from Person", Person.class).list();
			personList.forEach(b -> System.out.println(b));
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
