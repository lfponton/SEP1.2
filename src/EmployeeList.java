import java.io.Serializable;
import java.util.ArrayList;

public class EmployeeList implements Serializable
{
  private ArrayList<Employee> employees;

  // Constructors
  public EmployeeList()
  {
    employees = new ArrayList<Employee>();
  }

  // Size, add, and remove
  public void add(Employee employee)
  {
    employees.add(employee);
  }

  // Add Employee by index
  public void addByIndex(int index, Employee employee)
  {
    employees.add(index, employee);
  }
  // Several get methods
  // Return the Employee object at index if one exists,
  // else return null
  public Employee getEmployee(int index)
  {
    if(index<employees.size())
    {
      return (Employee) employees.get(index);
    }
    else
    {
      return null;
    }
  }

  // Get the Employee object with the given firstName and lastName
  // if one exists, else return null
  public Employee get(String firstName, String lastName, String role)
  {
    for(int i = 0; i<employees.size(); i++)
    {
      Employee temp = (Employee) employees.get(i);

      if(temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName) && temp.getRole().equals(role))
      {
        return temp;
      }
    }

    return null;
  }

  // Return the index of the Employee object with the given
  // firstName and lastName if one exists, else return -1
  public int getIndex(String firstName, String lastName, String role)
  {
    for(int i = 0; i<employees.size(); i++)
    {
      Employee temp = (Employee) employees.get(i);

      if(temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName) && temp.getRole().equals(role))
      {
        return i;
      }
    }
    return -1;
  }

  // Return how many Employee objects are in the list
  public int size()
  {
    return employees.size();
  }

  // Removes an Employee
  public void remove(Employee employee)
  {
    employees.remove(employee);
  }

  // Removes an Employee by index
  public void removeByIndex(int index)
  {
    employees.remove(index);
  }
  // toString

  // The toString method in ArrayList doesn't give a good result
  // with many Employee objects, so I make my own toString and
  // manually add a newline after each student
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<employees.size(); i++)
    {
      Employee temp = (Employee) employees.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }

}
