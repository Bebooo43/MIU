package edu.miu.cs.cs544.lab3_2_c;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@Entity
@ToString
@Table(name = "student")
public class Student { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private Integer studentId;
	private String firstName;
	private String lastName;
	@ManyToMany(mappedBy = "students")
	private List<Course> courses;
	
	public Student(Integer studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = new ArrayList<>();
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
} 