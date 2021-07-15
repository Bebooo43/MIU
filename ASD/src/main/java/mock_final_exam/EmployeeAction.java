package mock_final_exam;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAction implements Visitor {

    List<Manager> managerList;
    List<Employee> employeeList;

    public EmployeeAction(){
        managerList = new ArrayList<>();
        employeeList = new ArrayList<>();
    }

    @Override
    public void visit(Manager manager) {
        managerList.add(manager);
        employeeList.add(manager);
    }

    @Override
    public void visit(Employee employee) {
        employeeList.add(employee);
    }

    public List<Manager> getManagers() {
        return managerList;
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public Double getTotalSalary(){
        return employeeList.stream().mapToDouble(e -> e.getSalary()).sum();
    }

    public Double  getTotalAnnualSalary(){
        return getTotalSalary() * 12;
    }

    public Double getTotalAnnualBudget(){
        return getTotalAnnualSalary() + managerList.stream().mapToDouble(e-> e.getTeamBudget()).sum();
    }

}
