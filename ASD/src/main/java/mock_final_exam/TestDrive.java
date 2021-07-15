package mock_final_exam;

import java.time.LocalDate;

public class TestDrive {
    public static void main(String[] args) {
        //Managers
        Manager ceo = new Manager("0001","John","Santiago",
                                        LocalDate.of(1992,3,7),null);
        Manager manager1 = new Manager("0002","Peter","Santiago",
                                        LocalDate.of(1989,3,7),ceo);
        Manager manager2 = new Manager("0003","James","Santiago",
                                        LocalDate.of(1990,3,7),ceo);
        Manager manager3 = new Manager("0004","Paul","Santiago",
                                        LocalDate.of(1991,3,7),manager2);

        //Employees
        Employee employee5 = new Employee("0005","E5", "E5",
                                        LocalDate.of(1992,3,7),manager2);
        Employee employee6 = new Employee("0006","E6", "E6",
                                        LocalDate.of(1992,3,7),manager3);
        Employee employee7 = new Employee("0007","E7", "E7",
                                        LocalDate.of(1992,3,7),manager3);

        ceo.add(manager1); ceo.add(manager2);
        manager2.add(manager3);manager2.add(employee5);
        manager3.add(employee6);manager3.add(employee7);

        EmployeeAction visitor = new EmployeeAction();
        ceo.accept(visitor);

        System.out.println("\n----- MOCK EXAM -----");
        System.out.println("getManagers ("+visitor.managerList.size()+") = "+visitor.getManagers());
        System.out.println("getEmployees ("+visitor.employeeList.size()+") = "+visitor.getEmployees());
        System.out.println("getTotalSalary = "+visitor.getTotalSalary());
        System.out.println("getTotalAnnualSalary = "+visitor.getTotalAnnualSalary());
        System.out.println("getTotalAnnualBudget = "+visitor.getTotalAnnualBudget());
    }
}
