package cs544.team7.project.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Session {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private LocalDate date;
	@NotNull
	private LocalTime startTime;
	@NotNull
	private int duration;
	@NotNull
	private String location;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person provider;
	@OneToMany(mappedBy = "session", orphanRemoval = true)
	@JsonIgnore
	private Collection<Appointment> appointments = new ArrayList<>();
	
	public Session(LocalDate date, LocalTime startTime, int duration, String location, Person provider) {
		this.date = date;
		this.startTime = startTime;
		this.duration = duration;
		this.location = location;
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Session{" +
				"id=" + id +
				", date=" + date +
				", startTime=" + startTime +
				", duration=" + duration +
				", location='" + location + '\'' +
				", provider=" + provider +
				'}';
	}

	// Convenience methods

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}
	public void removeAppointment(Appointment appointment) {
		appointments.remove(appointment);
	}
	private void setAppointments(Collection<Appointment> a) {
		appointments = a;
	}
	public Collection<Appointment> getAppointments() {
		return Collections.unmodifiableCollection(appointments);
	}
	
}
