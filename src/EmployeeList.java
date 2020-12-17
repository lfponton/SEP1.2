import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Employee objects.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */

public class EmployeeList implements Serializable
{
  private ArrayList<Employee> employees;

  /**
   * No-argument constructor initializing the EmployeeList.
   */
  public EmployeeList()
  {
    employees = new ArrayList<Employee>();
  }

  /**
   * Adds an Employee to the list.
   * @param employee the employee to add to the list
   */
  public void add(Employee employee)
  {
    employees.add(employee);
  }

  /**
   * Adds an Employee to the list by index.
   * @param index the index in the list
   * @param employee the employee to add to the list
   */
  public void addByIndex(int index, Employee employee)
  {
    employees.add(index, employee);
  }

  /**
   * Gets an Employee object from position index from the list.
   * @param index the position in the list of the Employee object
   * @return the Employee object at position index if one exists, else null
   */
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

  /**
   * Gets how many Employee objects are in the list.
   * @return the number of Employee objects in the list
   */
  public int size()
  {
    return employees.size();
  }

  /**
   * Removes an Employee from the list.
   * @param employee the employee to remove from the list
   */
  public void remove(Employee employee)
  {
    employees.remove(employee);
  }

  /**
   * Removes an Employee to the list by index.
   * @param index the index in the list
   */
  public void removeByIndex(int index)
  {
    employees.remove(index);
  }

  /**
   * Gets a String representation of the EmployeeList.
   * @return a String containing information about all Employee objects in the list - each Employee object followed by a new line character
   */
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
