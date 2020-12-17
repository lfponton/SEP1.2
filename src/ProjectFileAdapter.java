import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the projects file, making it easy to retrieve and store information
 * for projects to a binary file and to an XML file.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class ProjectFileAdapter
{
  private MyFileIO mfio;
  private String binFileName;
  private MyTextFileIO mtfio;
  private String txtFileName;

  /**
   * 2-argument constructor setting the file names.
   * @param binFileName the name and path of the binary file where projects will be saved and retrieved
   * @param txtFileName the name and path of the xml file where projects will be saved and retrieved
   */
  public ProjectFileAdapter(String binFileName, String txtFileName)
  {
    mfio = new MyFileIO();
    mtfio = new MyTextFileIO();
    this.binFileName = binFileName;
    this.txtFileName = txtFileName;
  }

  /**
   * Uses the MyFileIO class to save a ProjectList object with all Projects.
   * @param projects the name of the ProjectList to be saved to the file.
   */
  public void saveProjects(ProjectList projects)
  {
    try
    {
      mfio.writeToFile(binFileName, projects);
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


  /**
   * Uses the MyFileIO class to retrieve a ProjectList object with all Projects.
   * @return a ProjectList object with all stored projects
   */
  public ProjectList getAllProjects()
  {
    ProjectList projects = new ProjectList();

    try
    {
      projects = (ProjectList) mfio.readObjectFromFile(binFileName);
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
    return projects;
  }

  /**
   * Uses the MyFileIO class to retrieve a RequirementList object with all Requirements.
   * @param projectId the id of the project containing the requirements
   * @return a RequirementList object with all stored requirements
   */
  public RequirementList getAllRequirements(String projectId)
  {
    ProjectList projects = getAllProjects();

    Project project = projects.getProjectById(projectId);

    return project.getRequirements();
  }

  /**
   * Uses the MyFileIO class to retrieve a TaskList object with all Tasks.
   * @param projectId the id of the project containing the requirements
   * @param requirementId the id of the requirement containing the tasks
   * @return a TaskList object with all stored tasks
   */
  public TaskList getAllTasks(String projectId, String requirementId)
  {
    RequirementList requirements = getAllRequirements(projectId);

    Requirement requirement = requirements.getRequirementById(requirementId);

    return requirement.getTasks();
  }

  /**
   * Uses the MyFileIO class to add a Project to the projects file.
   * @param project the Project object to be added to the file.
   */
  public void addProject(Project project)
  {
    ProjectList projects = getAllProjects();

    projects.addProject(project);

    saveProjects(projects);
  }

  /**
   * Uses the MyFileIO class to add a Requirement to the projects file.
   * @param projectId the id of the project containing the requirements
   * @param requirement the Requirement object to be added to the file.
   */
  public void addRequirement(String projectId, Requirement requirement)
  {
    ProjectList projects = getAllProjects();

    RequirementList requirements = getAllRequirements(projectId);

    requirements.addRequirement(requirement);

    projects.getProjectById(projectId).setRequirements(requirements);

    saveProjects(projects);
  }

  /**
   * Uses the MyFileIO class to add a RequirementList to the projects file.
   * @param projectId the id of the project containing the requirements
   * @param requirements the RequirementList object to be added to the file.
   */
  public void addRequirements(String projectId, RequirementList requirements)
  {
    ProjectList projects = getAllProjects();
    projects.getProjectById(projectId).setRequirements(requirements);

    saveProjects(projects);
  }

  /**
   * Uses the MyFileIO class to add a Task to the projects file. It sets the
   * total hours of the tasks to the requirement.
   * @param projectId the id of the project containing the requirements
   * @param requirementId the id of the requirement containing the tasks
   * @param task the Task object to be added to the file.
   */
  public void addTask(String projectId, String requirementId, Task task)
  {
    ProjectList projects = getAllProjects();

    RequirementList requirements = getAllRequirements(projectId);

    TaskList tasks = getAllTasks(projectId, requirementId);

    tasks.addTask(task);

    Requirement req = requirements.getRequirementById(requirementId);

    requirements.getRequirementById(requirementId).setTasks(tasks);

    req.setHours();

    projects.getProjectById(projectId).setRequirements(requirements);

    saveProjects(projects);
  }

  /**
   * Uses the MyFileIO class to add a TaskList to the projects file. It sets the
   * total hours of the tasks to the requirement.
   * @param projectId the id of the project containing the requirements
   * @param requirementId the id of the requirement containing the tasks
   * @param tasks the TaskList object to be added to the file.
   */
  public void addTasks(String projectId, String requirementId, TaskList tasks)
  {
    ProjectList projects = getAllProjects();

    RequirementList requirements = getAllRequirements(projectId);

    requirements.getRequirementById(requirementId).setTasks(tasks);

    Requirement req = requirements.getRequirementById(requirementId);

    req.setHours();
    
    projects.getProjectById(projectId).setRequirements(requirements);

    saveProjects(projects);
  }

  /**
   * Uses the MyFileTextIO class to create an XML file with relevant information
   * to be displayed in a website.
   */
public void XMLConverter()
{
  ProjectList projects = getAllProjects();
  String XMLOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
      "<projects>";
  for (int i = 0; i < projects.size(); i++)
  {
    Project project = projects.getProject(i);
    XMLOutput += "<project><title>" + project.getTitle() +
        "</title><description>" + project.getDescription() + "</description>";
    String projectId = project.getId();
    RequirementList requirements = getAllRequirements(projectId);

    for (int j = 0; j < requirements.size(); j++)
    {
      Requirement requirement = project.getRequirements().getRequirement(j);
      if (requirement != null)
      {
        XMLOutput += "<requirement><description>" + requirement
            .getDescription() + "</description><status>" + requirement
            .getStatus() + "</status>" + "<deadline>" + requirement
            .getDeadline() + "</deadline><type>" + requirement.getType()
            + "</type></requirement>";
      }
      else
      {
        XMLOutput += "<requirement><description></description>"
            + "<status></status><deadline></deadline><type></type></requirement>";
      }
    }
    XMLOutput += "</project>";
  }
  XMLOutput += "</projects>";

  try
  {
    mtfio.writeToFile(txtFileName, XMLOutput);
  }

  catch (FileNotFoundException e)
  {
    System.out.println("File not found");
  }
}
}
