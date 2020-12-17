import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * An adapter to the employees file, making it easy to retrieve and store information
 * for employees to a binary file.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class EmployeeFileAdapter
{
  private MyFileIO mfio;
  private String fileName;

  /**
   * 1-argument constructor setting the file names.
   * @param fileName the name and path of the binary file where projects will be saved and retrieved
   */
  public EmployeeFileAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }

  /**
   * Uses the MyFileIO class to retrieve an EmployeeList object with all Employees.
   * @return an EmployeeList object with all stored employees
   */
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

  /**
   * Uses the MyFileIO class to add an Employee to the employees file.
   * @param employee the Employee object to be added to the file.
   */
  public void addEmployee(Employee employee)
  {
    EmployeeList employees = getAllEmployees();

    employees.add(employee);

    saveEmployee(employees);
  }

  /**
   * Uses the MyFileIO class to save a EmployeeList object with all Employees.
   * @param employees the name of the EmployeeList to be saved to the file.
   */
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
