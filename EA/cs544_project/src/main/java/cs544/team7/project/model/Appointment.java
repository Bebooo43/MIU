package cs544.team7.project.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private LocalDateTime requestTime = LocalDateTime.now();
	@NotNull
	private AppointmentStatus status = AppointmentStatus.PENDING;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person client;
	@ManyToOne
	@JoinColumn(name = "session_id")
	private Session session;
	
	public Appointment(Person client, Session session) {
		this.client = client;
		this.session = session;
		client.addAppointment(this);
		session.addAppointment(this);
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"id=" + id +
				", requestTime=" + requestTime +
				", status=" + status +
				", client=" + client +
				", session=" + session +
				'}';
	}
}
