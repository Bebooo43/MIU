package edu.miu.cs544.lab15.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@NoArgsConstructor @Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {

	@Id
	private Long id;
	private String name;
	private String code;
}
