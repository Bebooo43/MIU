package cs544.team7.project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.team7.project.model.Appointment;

@Repository
@Transactional//Required by default (reuse or create new if not find)
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
}
