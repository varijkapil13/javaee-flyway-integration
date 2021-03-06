package dev.varij.flyway.persistence.repository;

import dev.varij.flyway.persistence.modal.Person;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@RequestScoped
@Transactional(value = TxType.REQUIRED)
public class PersonRepository {
  
  @PersistenceContext(unitName = "dev.varij.flyway.persistence.unit")
  private EntityManager entityManager;
  
  public Person save(Person person) {
    entityManager.persist(person);
    entityManager.flush();
    return person;
  }
  
  public List<Person> getAll() {
    final TypedQuery<Person> namedQuery = entityManager.createNamedQuery(Person.FIND_ALL, Person.class);
    return namedQuery.getResultList();
  }
  
}
