package dev.varij.flyway.controller;

import dev.varij.flyway.persistence.modal.Person;
import dev.varij.flyway.persistence.repository.PersonRepository;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PersonController {
  
  @Inject
  private PersonRepository personRepository;
  
  
  public List<Person> getAllPersons() {
    return personRepository.getAll();
  }
}
