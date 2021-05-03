package edu.miu.cs.cs544.app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.miu.cs.cs544.examples.HibernateUtils;
import edu.miu.cs.cs544.lab7_1.AirPlane;
import edu.miu.cs.cs544.lab7_1.Airline;
import edu.miu.cs.cs544.lab7_1.Airport;
import edu.miu.cs.cs544.lab7_1.Flight;

public class App {

	private static final SessionFactory sessionFactory;
	private Transaction tx;
	
	static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
				Airline.class, AirPlane.class, Airport.class, Flight.class
				
		));
	}
	
	public static void main(String[] args) {
		App app = new App();
		
		//Airports
		Airport airportDTW = new Airport("Detroit Metropolitan Wayne County Airport","Detroid","USA","DTW");
		Airport airportHND = new Airport("Haneda Airport","Tokyo","Japan","HND");
		Airport airportLAX = new Airport("Los Angeles International Airport","Los Angeles","USA","LAX");
		Airport airportSYD = new Airport("Sidney Airport","Sydney","Australia","SYD");
		Airport airportORD = new Airport("O'Hare International Airport","Chicago","USA","ORD");
		Airport airportAMS = new Airport("Amsterdam Airport Schiphol","Amsterdam","Netherlands","AMS");
		Airport airportFRA = new Airport("Frankfurt Airport","Frankfurt","Germany","FRA");
		Airport airportLCY = new Airport("London City Airport","London","England","LCY");
		Airport airportJFK = new Airport("John F. Kennedy International Airport","New York","USA","JFK");
		Airport airportSIN = new Airport("Singapore Changi Airport","Singapore","Singapore","SIN");
		
		app.persist(airportDTW);app.persist(airportHND);app.persist(airportLAX);app.persist(airportSYD);
		app.persist(airportORD);app.persist(airportAMS);app.persist(airportFRA);app.persist(airportLCY);
		app.persist(airportJFK);app.persist(airportSIN);
		
		//Airlines and Airplanes
		Airline airlineAA = new Airline("American Airlines");
		Airline airlineSA = new Airline("Star Alliance");
		app.persist(airlineAA);app.persist(airlineSA);
		
		AirPlane airplaneA380 = new AirPlane("S380083", "A380", 300);
		AirPlane airplane747 = new AirPlane("S747747", "747", 600);
		app.persist(airplaneA380);app.persist(airplane747);
		
		Flight flight_NW36 = new Flight("NW 36", LocalDate.of(2009, 8, 6), LocalTime.of(19, 10), LocalDate.of(2009, 8, 7), LocalTime.of(9, 0), airlineAA, airplaneA380, airportDTW, airportAMS);
		Flight flight_NW96 = new Flight("NW 96", LocalDate.of(2009, 8, 6), LocalTime.of(15, 05), LocalDate.of(2009, 8, 7), LocalTime.of(13, 45), airlineAA, airplaneA380, airportHND, airportDTW);
		Flight flight_QF12 = new Flight("QF 12", LocalDate.of(2009, 8, 5), LocalTime.of(22, 30), LocalDate.of(2009, 8, 7), LocalTime.of(6, 15), airlineAA, airplaneA380, airportLAX, airportSYD);
		Flight flight_QF21 = new Flight("QF 21", LocalDate.of(2009, 8, 6), LocalTime.of(21, 55), LocalDate.of(2009, 8, 7), LocalTime.of(6, 55), airlineAA, airplane747, airportSYD, airportHND);
		Flight flight_UA944 = new Flight("UA 944", LocalDate.of(2009, 8, 6), LocalTime.of(14, 30), LocalDate.of(2009, 8, 7), LocalTime.of(5, 45), airlineAA, airplane747, airportORD, airportFRA);
		Flight flight_UA934 = new Flight("UA 934", LocalDate.of(2009, 8, 6), LocalTime.of(12, 59), LocalDate.of(2009, 8, 7), LocalTime.of(7, 30), airlineAA, airplane747, airportLAX, airportLCY);
		Flight flight_NW8445 = new Flight("NW 8445", LocalDate.of(2009, 8, 7), LocalTime.of(7, 15), LocalDate.of(2009, 8, 7), LocalTime.of(7, 40), airlineSA, airplaneA380, airportAMS, airportLCY);
		Flight flight_NW1689 = new Flight("NW 1689", LocalDate.of(2009, 8, 7), LocalTime.of(12, 05), LocalDate.of(2009, 8, 7), LocalTime.of(12, 21), airlineSA, airplaneA380, airportDTW, airportORD);
		Flight flight_QF3101 = new Flight("QF 3101", LocalDate.of(2009, 8, 7), LocalTime.of(15, 0), LocalDate.of(2009, 8, 7), LocalTime.of(23, 39), airlineSA, airplaneA380, airportLAX, airportJFK);
		Flight flight_QF4022 = new Flight("QF 4022", LocalDate.of(2009, 8, 7), LocalTime.of(11, 05), LocalDate.of(2009, 8, 7), LocalTime.of(17, 55), airlineSA, airplane747, airportHND, airportSIN);
		Flight flight_UA941 = new Flight("UA 941", LocalDate.of(2009, 8, 7), LocalTime.of(12, 45), LocalDate.of(2009, 8, 7), LocalTime.of(14, 53), airlineSA, airplane747, airportFRA, airportORD);
		Flight flight_UA4842 = new Flight("UA 4842", LocalDate.of(2009, 8, 7), LocalTime.of(8, 10), LocalDate.of(2009, 8, 7), LocalTime.of(10, 38), airlineSA, airplane747, airportLCY, airportAMS);
		
		app.persist(flight_NW36); app.persist(flight_NW96); app.persist(flight_QF12); app.persist(flight_QF21); 
		app.persist(flight_UA944); app.persist(flight_UA934); app.persist(flight_NW8445); app.persist(flight_NW1689);
		app.persist(flight_QF3101); app.persist(flight_QF4022); app.persist(flight_UA941); app.persist(flight_UA4842); 
		
		app.printFlightsFromUSACapacityBigger500();
		app.printAirlinesWithA380Airplanes();
		app.printFlightsPlane747NotStarAlliance();
		app.printFlightsBeforeDateTime();
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
	
	public void printFlightsFromUSACapacityBigger500() {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();			
			List<Flight> list = session.createQuery("select f from Flight f where f.origin.country = :country and f.airplane.capacity > 500", Flight.class).setParameter("country", "USA").list();
			System.out.println("\n-------- All flights leaving USA with capacity > 500  ------- ");
			list.forEach(o -> System.out.println(o));
			System.out.println();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void printAirlinesWithA380Airplanes() {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();			
			List<Airline> list = session.createQuery("select distinct a from Flight f join f.airline a where f.airplane.model = :model", Airline.class).setParameter("model", "A380").list();
			System.out.println("\n-------- All airlines that use A380 (model) airplanes  ------- ");
			list.forEach(o -> System.out.println(o));
			System.out.println();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void printFlightsPlane747NotStarAlliance() {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();			
			List<Flight> list = session.createQuery("select f from Flight f where f.airplane.model = :model and f.airline.name != :airline", Flight.class).setParameter("model", "747").setParameter("airline", "Star Alliance").list();
			System.out.println("\n-------- All flights using 747 planes that don't belong to 'Star Alliance'  -------");
			list.forEach(o -> System.out.println(o));
			System.out.println();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void printFlightsBeforeDateTime() {
		try(Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();			
			List<Flight> list = session.createQuery("select f from Flight f where f.departureDate = :departureDate and hour(f.departureTime) < 12", Flight.class).setParameter("departureDate", LocalDate.of(2009, 8, 7)).list();
			//flights leaving before 12pm on 08/07/2009
			System.out.println("\n-------- All flights leaving before 12pm on 08/07/2009  -------");
			list.forEach(o -> System.out.println(o));
			System.out.println();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
}
