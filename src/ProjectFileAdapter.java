import java.io.FileNotFoundException;
import java.io.IOException;

public class ProjectFileAdapter
{
  private MyFileIO mfio;
  private String fileName;

  // Constructor
  public ProjectFileAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }

  // Use the MyFileIO class to save all Projects in the ProjectList object
  public void saveProjects(ProjectList projects)
  {
    try
    {
      mfio.writeToFile(fileName, projects);
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


  // Use the MyFileIO class to retrieve a ProjectList object with all Projects
  public ProjectList getAllProjects()
  {
    ProjectList projects = new ProjectList();

    try
    {
      projects = (ProjectList) mfio.readObjectFromFile(fileName);
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

  // Use the gwtAllProjects() class to retrieve a RequirementList object with
  // all Requirements for the given project id
  public RequirementList getAllRequirements(String projectId)
  {
    ProjectList projects = getAllProjects();

    Project project = projects.getProjectById(projectId);

    return project.getRequirements();
  }

  // Use the gwtAllRequirements() class to retrieve a TaskList object with
  // all Tasks for the given project and requirement ids
  public TaskList getAllTasks(String projectId, String requirementId)
  {
    RequirementList requirements = getAllRequirements(projectId);

    Requirement requirement = requirements.getRequirementById(requirementId);

    return requirement.getTasks();
  }

  // Add methods
  public void addProject(Project project)
  {
    ProjectList projects = getAllProjects();

    projects.addProject(project);

    saveProjects(projects);
  }

  public void addRequirement(String projectId, Requirement requirement)
  {
    ProjectList projects = getAllProjects();

    RequirementList requirements = getAllRequirements(projectId);

    requirements.addRequirement(requirement);

    projects.getProjectById(projectId).setRequirements(requirements);

    saveProjects(projects);
  }

  public void addRequirements(String projectId, RequirementList requirements)
  {
    ProjectList projects = getAllProjects();
    projects.getProjectById(projectId).setRequirements(requirements);

    saveProjects(projects);
  }

  public void addTask(String projectId, String requirementId, Task task)
  {
    ProjectList projects = getAllProjects();

    RequirementList requirements = getAllRequirements(projectId);

    TaskList tasks = getAllTasks(projectId, requirementId);

    tasks.addTask(task);

    requirements.getRequirementById(requirementId).setTasks(tasks);

    projects.getProjectById(projectId).setRequirements(requirements);

    saveProjects(projects);
  }

  public void addTasks(String projectId, String requirementId, TaskList tasks)
  {
    ProjectList projects = getAllProjects();

    RequirementList requirements = getAllRequirements(projectId);

    requirements.getRequirementById(requirementId).setTasks(tasks);

    projects.getProjectById(projectId).setRequirements(requirements);

    saveProjects(projects);
  }

  // Edit and Remove methods below
  public void editProject(String id, Project editedProject)
  {
    ProjectList projects = getAllProjects();

    for (int i = 0; i < projects.size(); i++)
    {
      Project project = projects.getProject(i);

      if (project.getId().equals(id))
      {
        projects.removeProject(project);
        projects.addProject(i, editedProject);
        break;
      }
    }
    saveProjects(projects);
  }

  public void removeProject(String id)
  {
    ProjectList projects = getAllProjects();

    for (int i = 0; i < projects.size(); i++)
    {
      Project project = projects.getProject(i);

      if (project.getId().equals(id))
      {
        projects.removeProject(project);
        break;
      }
    }
    saveProjects(projects);
  }
}
