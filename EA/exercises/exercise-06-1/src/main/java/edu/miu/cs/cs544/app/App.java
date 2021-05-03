package edu.miu.cs.cs544.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.miu.cs.cs544.examples.HibernateUtils;
import edu.miu.cs.cs544.lab6_1.Appointment;
import edu.miu.cs.cs544.lab6_1.Doctor;
import edu.miu.cs.cs544.lab6_1.Patient;
import edu.miu.cs.cs544.lab6_1.Payment;

public class App {

	private static final SessionFactory sessionFactory;
	private Transaction tx;
	
	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
				Appointment.class, Doctor.class, Patient.class, Payment.class
				
		));
	}
	
	public static void main(String[] args) {
		App app = new App();
		Patient patient = new Patient("John Thomas","King James Street","55876","Nauvoo");
		Patient patient2 = new Patient("Jennyfer Corner","10th St","52556","Faiefield");

		Doctor doctor = new Doctor("Pediatric", "Daniel", "Gemmenti");
		Payment payment1 = new Payment("2021/05/01", 30.0);
		Payment payment2 = new Payment("2021/06/01", 33.0);
		Payment payment3 = new Payment("2021/07/01", 35.0);
		
		Appointment appointment = new Appointment("App Date", patient, payment1, doctor);
		Appointment appointment2 = new Appointment("App Date2 ", patient, payment2, doctor);
		Appointment appointment3 = new Appointment("App Date 3", patient2, payment3, doctor);
		
		app.persist(patient);
		app.persist(patient2);
		app.persist(doctor);
		app.persist(appointment);
		app.persist(appointment2);
		app.persist(appointment3);
		
		System.out.println("\n-------- Print  -------");
		app.print(appointment);
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
			System.out.println();
			list.forEach(o -> System.out.println(o));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
