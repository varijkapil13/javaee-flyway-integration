package dev.varij.flyway.controller;

import dev.varij.flyway.persistence.modal.Person;
import dev.varij.flyway.persistence.repository.PersonRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RegistrationController {
  
  @Inject
  private PersonRepository personRepository;
  
  public Person savePerson(Person person) {
    if (person == null) {
      return null;
    }
    return personRepository.save(person);
  }
  
}
