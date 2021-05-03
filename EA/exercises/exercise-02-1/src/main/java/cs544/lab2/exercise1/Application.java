package cs544.lab2.exercise1;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class Application {

	private static SessionFactory sessionFactory;
	final static Logger logger = Logger.getLogger(Car.class);
	

	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public static void main(String[] args) {
		Transaction transation = null;
		
		// Create new instance of Employee and set values in it
		Car c1 = new Car("Ford",2015,20.000);
		Car c2 = new Car("Honda2",2018,25.000);
		runMe("mkyong");
		// insert or update the cars
		try(Session session = sessionFactory.openSession()) {
			transation = session.beginTransaction();
			session.persist(c1);
			session.persist(c2);
			transation.commit();
			
		} catch (HibernateException e) {
			transation.rollback();
			e.printStackTrace();
		}
		
		//retrieve all cars
		try(Session session = sessionFactory.openSession()) {
			transation = session.beginTransaction();
			List<Car> carList = session.createQuery("from Car", Car.class).list();
			carList.forEach(c -> System.out.println(c));
			transation.commit();
		} catch (HibernateException e) {
			transation.rollback();
			e.printStackTrace();
		}
	}
	
	
	 static void runMe(String parameter){
	        
	        if(logger.isDebugEnabled()){
	            logger.debug("This is debug : " + parameter);
	        }
	        
	        if(logger.isInfoEnabled()){
	            logger.info("This is info : " + parameter);
	        }
	        
	        logger.warn("This is warn : " + parameter);
	        logger.error("This is error : " + parameter);
	        logger.fatal("This is fatal : " + parameter);
	        
	    }

}
