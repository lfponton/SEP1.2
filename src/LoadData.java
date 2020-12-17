/**
 * A program used for importing data to the projects file and employees file.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */

public class LoadData
{
  public static void main(String[] args)
  {
    // This class is only used to load data into the file.

    ProjectFileAdapter pfa = new ProjectFileAdapter(
        "projects.bin", "projects.xml");
    EmployeeFileAdapter efa = new EmployeeFileAdapter("employees.bin");

    EmployeeList employees = new EmployeeList();
    /*Employee empty = new Employee("", "", "");*/
    Employee alina = new Employee("Alina", "Chelmus", "Team Member");
    Employee agos = new Employee("Agostina", "Mezzabotta", "Team Member");
    Employee luis = new Employee("Luis", "Fernandez", "Team Member");

   // employees.add(empty);// do not delete
    employees.add(alina);
    employees.add(agos);
    employees.add(luis);

    efa.saveEmployee(employees);

    ProjectList list = new ProjectList();
    list.addProject(new Project("1", "Lorem ipsum dolor sit amet.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
    list.addProject(new Project("2", "Lorem ipsum dolor sit amet.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
    list.addProject(new Project("3", "Lorem ipsum dolor sit amet.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

    RequirementList reqs = new RequirementList();

    for (int i = 1; i <= 21; i++)
    {
      String id = Integer.toString(i);
      String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

      reqs.addRequirement(new Requirement(id, "Functional", description, "Critical", "No Started",  100, 0, Date.today(),luis));
    }

    TaskList tasks = new TaskList();

    for (int i = 1; i <= 20; i++)
    {
      String id = Integer.toString(i);
      tasks.addTask(new Task(id, "Not Started", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 5, 0, Date.today(), alina));
    }


    reqs.getRequirement(0).setTasks(tasks);

    list.getProject(0).setRequirements(reqs);

    RequirementList reqs1 = new RequirementList();

    for (int i = 1; i <= 31; i++)
    {
      String id = Integer.toString(i);
      reqs1.addRequirement(new Requirement(id, "Not Started", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",  Date.today(),100, 0, luis));
    }

    TaskList tasks1 = new TaskList();

    for (int i = 1; i <= 16; i++)
    {
      String id = Integer.toString(i);
      tasks1.addTask(new Task(id, "Not Started", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 5, 0, Date.today(), agos));
    }

    reqs.getRequirement(1).setTasks(tasks1);

    list.getProject(1).setRequirements(reqs1);

    RequirementList reqs2 = new RequirementList();

    for (int i = 1; i <= 51; i++)
    {
      String id = Integer.toString(i);
      String description = "Lorem ipsum dolor sit";

      reqs.addRequirement(new Requirement(id, "Functional",description,"Critical","Non Started",100,100, Date.today(),   luis));
    }

    TaskList tasks2 = new TaskList();

    for (int i = 1; i <= 11; i++)
    {
      String id = Integer.toString(i);
      tasks2.addTask(new Task(id, "Not Started", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 5, 0, Date.today(), luis));
    }

    reqs.getRequirement(2).setTasks(tasks2);

    list.getProject(2).setRequirements(reqs2);

    pfa.saveProjects(list);
  }
}