import java.io.FileNotFoundException;
import java.io.IOException;

public class EmployeeFileAdapter
{
  private MyFileIO mfio;
  private String fileName;

  public EmployeeFileAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }

  // Use the MyFileIO class to retrieve a EmployeeList object with all Employee
  public EmployeeList getAllEmployees()
  {
    EmployeeList employee = new EmployeeList();

    try
    {
      employee = (EmployeeList)mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return employee;
  }

  // Add employee
  public void addEmployee(Employee employee)
  {
    EmployeeList employees = getAllEmployees();

    employees.add(employee);

    saveEmployee(employees);
  }

  /*
  // Use the MyFileIO class to retrieve a StudentList object with all Students
  // from the given country
  public EmployeeList getEmployeeFrom(String fromProjects)
  {
    EmployeeList employee = new EmployeeList();

    try
    {
      EmployeeList result = (EmployeeList)mfio.readObjectFromFile(fileName);

      for (int i = 0; i < result.size(); i++)
      {
        if (result.getEmployee(i).getEmployeeFrom().equals(fromProjects))
        {
          employee.add(result.getEmployee(i));
        }
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }

    return employee;
  }

   */

  // Use the MyFileIO class to save all Students in the StudentList object
  public void saveEmployee(EmployeeList employees)
  {
    try
    {
      mfio.writeToFile(fileName, employees);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
/*
  // Edit employee with the given firstname and lastname
  public void editEmployee(String firstName, String lastName, String role)
  {
    EmployeeList employee = getAllEmployees();

    for (int i = 0; i < employee.size(); i++)
    {
      Employee employees = null;
      employees = employee.getEmployee(i);

      if (employees.getFirstName().equals(firstName) && employees.getLastName().equals(lastName))
      {
        employees.setRole(role);
      }
    }

    saveEmployee(employees);
  }

 */

}
