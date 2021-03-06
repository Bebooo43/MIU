package lab10.prob5.soln2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lab10.prob5.Employee;
import lab10.prob5.Main;

public class Maintest2 {

	Employee employee;
	Main main;
	
	@Before
	public void setUp() throws Exception {
		main = new Main();
		employee = new Employee("Johnathan", "Santiago", 150000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSalaryGreaterThan100000() {
		assertEquals(main.salaryGreaterThan100000(employee), true);
	}

	@Test
	public void testLastNameAfterM() {
		assertEquals(main.lastNameAfterM(employee), true);
	}

	@Test
	public void testFullName() {
		assertEquals(main.fullName(employee), "Johnathan Santiago");
	}

}
