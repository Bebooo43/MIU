package edu.miu.cs.cs544.lab4_1_c;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@Entity
@ToString
@Table(name = "school")
public class School { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String name; 
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "school_id")
	@MapKey(name="studentId")
	private Map<Integer,Student> students;
	
	public School(String name, Student student) {
		this.name = name;
		this.students = new HashMap<Integer,Student>();
		this.students.put(student.getStudentId(), student);
	}
} 