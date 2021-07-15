package mock_final_exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee{

    private List<EmployeeComponent> employeeList;
    private Double bonus;
    private Double teamBudget;

    public Manager(String employeeId, String firstName, String lastName, LocalDate birthDate,Manager manager) {
        super(employeeId, firstName, lastName, birthDate,manager);
        employeeList = new ArrayList();
        bonus = super.getSalary() * 0.1;//10%
        teamBudget = 10000.0;
    }

    public void add(EmployeeComponent employeeComponent){
        employeeList.add(employeeComponent);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        employeeList.forEach(m -> m.accept(visitor));
    }

    //Getters and Setters
    public Double getBonus() { return bonus; }
    public void setBonus(Double bonus) { this.bonus = bonus; }
    public Double getTeamBudget() { return teamBudget; }
    public void setTeamBudget(Double teamBudget) { this.teamBudget = teamBudget; }
    @Override
    public Double getSalary() {
        return super.getSalary() + getBonus();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                ", teamBudget=" + teamBudget +
                ", "+ super.toString()+ "}";
    }
}
