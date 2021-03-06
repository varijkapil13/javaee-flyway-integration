package dev.varij.flyway.view;

import dev.varij.flyway.controller.PersonController;
import dev.varij.flyway.controller.RegistrationController;
import dev.varij.flyway.persistence.modal.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class PersonView {
  
  @Getter
  @Setter
  private List<Person> people = new ArrayList<>();
  
  @Getter
  @Setter
  private String firstName;
  
  @Getter
  @Setter
  private String lastName;
  
  @Inject
  private PersonController personController;
  
  @Inject
  private RegistrationController registrationController;
  
  @PostConstruct
  public void init() {
    this.updateUsers();
  }
  
  private void updateUsers() {
    this.people = personController.getAllPersons();
  }
  
  public void createPerson() {
    final Person person = Person.builder()
        .firstName(this.firstName)
        .lastName(this.lastName)
        .build();
    
    registrationController.savePerson(person);
    this.updateUsers();
    this.firstName = null;
    this.lastName = null;
    FacesContext
        .getCurrentInstance()
        .addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User was added successfully"));
  }
}
