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

  // toString

  public String toString()
  {
    return firstName + " " + lastName;
  }
}
