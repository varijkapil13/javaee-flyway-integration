package dev.varij.flyway.rest;

import dev.varij.flyway.controller.PersonController;
import dev.varij.flyway.controller.RegistrationController;
import dev.varij.flyway.persistence.modal.Person;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class PersonResource {
  
  @Inject
  private RegistrationController registrationController;
  
  @Inject
  private PersonController personController;
  
  @GET
  public Response fetchAllPersons() {
    final List<Person> allPeople = personController.getAllPersons();
    return Response.ok().entity(allPeople).build();
  }
  
  @POST
  public Response createPerson(@Valid Person person) {
    final Person createdPerson = registrationController.savePerson(person);
    return Response.ok().entity(createdPerson).build();
  }
}
