package cs544.team7.project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Person {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String fname;
	@NotNull
	private String lname;
	@Email
	private String email;
	@NotNull
	@Size(min=3)
	private String username;
	@NotNull
	@Size(min=3)
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
	private String password;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Person_Role", 
			   joinColumns = @JoinColumn(name = "person_id"), 
			   inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles = new LinkedList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "client", orphanRemoval = true)
	private Collection<Appointment> appointments = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "provider", orphanRemoval = true)
	private Collection<Session> sessions = new ArrayList<>();

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", fname='" + fname + '\'' +
				", lname='" + lname + '\'' +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", roles=" + roles +
				'}';
	}
	


	public Person(String fname, String lname, String email, String username, String password, Collection<Role> roles) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	// Convenience methods

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}
	public void removeAppointment(Appointment appointment) {
		if(appointment.getClient() == this)
			appointments.remove(appointment);
		else
			throw new IllegalArgumentException("This appointment belongs to other user");
	}
	private void setAppointments(Collection<Appointment> a) {
		appointments = a;
	}
	public Collection<Appointment> getAppointments() {
		return Collections.unmodifiableCollection(appointments);
	}

	public void addSession(Session session) {
		sessions.add(session);
	}
	public void removeSession(Session session) {
		if(session.getProvider() == this)
			sessions.remove(session);
		else
			throw new IllegalArgumentException("This appointment belongs to other user");
	}
	private void setSessions(Collection<Session> s) {
		sessions = s;
	}
	public Collection<Session> getSessions() {
		return Collections.unmodifiableCollection(sessions);
	}

	public void addRole(Role role) {
		if(!roles.contains(role)) roles.add(role);
	}
	public void removeRole(Role role) {
		if(roles.contains(role)) roles.remove(role);
	}
	public Collection<Role> getRoles() {
		return Collections.unmodifiableCollection(roles);
	}
}
