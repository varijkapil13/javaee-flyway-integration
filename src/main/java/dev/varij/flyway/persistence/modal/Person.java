package dev.varij.flyway.persistence.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Person.TABLE_NAME)
@NamedQuery(name = Person.FIND_ALL, query = "select u from Person u")
public class Person extends Audit {
  
  public static final String TABLE_NAME = "person";
  public static final String FIND_ALL = TABLE_NAME + ".FIND_ALL";
  
  
  @NotEmpty
  @Size(min = 2, message = "First Name have minimum of 2 characters")
  @Column(name = "first_name")
  private String firstName;
  
  @NotEmpty
  @Size(min = 2, message = "Last Name have minimum of 2 characters")
  @Column(name = "last_name")
  private String lastName;
  
}
