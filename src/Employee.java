import java.io.Serializable;

/**
 * A class representing an Employee with a first name, last name and role.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */

public class Employee implements Serializable
{
  private String firstName,lastName, role;

  /**
   * Three-argument constructor.
   * @param firstName the employee's first name
   * @param lastName the employee's last name
   * @param role the employee's role
   */
  public Employee(String firstName, String lastName, String role)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
  }

  /**
   * Gets the employee's first name.
   * @return the student's first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the employee's last name.
   * @return the employee's last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Gets the employee's role.
   * @return the employee's role
   */
  public String getRole()
  {
    return role;
  }

  /**
   * Returns a string representation of the employee.
   * @return a string representation of the employee in the format: "firstName lastName"
   */
  public String toString()
  {
    return firstName + " " + lastName;
  }
}
