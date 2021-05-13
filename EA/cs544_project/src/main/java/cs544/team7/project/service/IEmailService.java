package cs544.team7.project.service;

import cs544.team7.project.model.Person;

public interface IEmailService {
	public void sendMessage(Person person, String message);
}
