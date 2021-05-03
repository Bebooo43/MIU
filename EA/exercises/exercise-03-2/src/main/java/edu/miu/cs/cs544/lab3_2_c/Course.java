package edu.miu.cs.cs544.lab3_2_c;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer courseNumber;
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "course_student",
			joinColumns = { @JoinColumn(name="course_id")}, 
			inverseJoinColumns = {@JoinColumn(name="student_id")})
	private List<Student> students;
	
	public Course(Integer courseNumber, String name) {
		super();
		this.courseNumber = courseNumber;
		this.name = name;
		this.students = new ArrayList<>();
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
}
