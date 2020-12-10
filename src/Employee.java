import java.io.Serializable;

public class Employee implements Serializable
{
  private String firstName,lastName, role;

  // Constructors
  public Employee(String firstName, String lastName, String role)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
  }

  public Employee(String firstName)
  {
    this.firstName = firstName;
  }
  // Getters
  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public String getRole()
  {
    return role;
  }

  // Setters
  public void setRole(String role) {
    this.role = role;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  // toString

  public String toString()
  {
    return lastName + ", " + firstName;
  }
}
