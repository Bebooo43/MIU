package edu.miu.cs.cs544.lab3_2_f;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "department_f")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "department")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Set<Employee> employess;
	
	public Department(String name) {
		this.name = name;
		this.employess = new HashSet<>();
	}
	
	public void addEmployee(Employee employee) {
		employess.add(employee);
	}
}
