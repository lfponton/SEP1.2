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
}
