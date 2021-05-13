package cs544.team7.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "appointment not found")
public class AppointmentNotFoundException extends RuntimeException {

}