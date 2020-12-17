import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Project objects.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class ProjectList implements Serializable
{
  private ArrayList<Project> projects;

  /**
   * No-argument constructor initializing the ProjectList.
   */
  public ProjectList()
  {
    projects = new ArrayList<Project>();
  }

  /**
   * Adds a Project to the list by index.
   * @param index the index in the list
   * @param project the project to add to the list
   */
  public void addProject(int index, Project project)
  {
    projects.add(index, project);
  }

  /**
   * Gets how many Project objects are in the list.
   * @return the number of Project objects in the list
   */
  public int size()
  {
    return projects.size();
  }

  /**
   * Adds an Project to the list.
   * @param project the employee to add to the list
   */
  public void addProject(Project project)
  {
    projects.add(project);
  }

  /**
   * Removes a Project from the list by index.
   * @param index the index in the list
   */
  public void removeProjectByIndex(int index)
  {
    if (index < projects.size())
    {
      projects.remove(index);
    }
  }

  /**
   * Gets a Project object from position index from the list.
   * @param index the position in the list of the Project object
   * @return the Project object at position index if one exists, else null
   */
  public Project getProject(int index)
  {
    if(index<projects.size())
    {
      return projects.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Gets an Project object from position by the project's id.
   * @param id of the Project object
   * @return the Project object at position index if one exists, else null
   */
  public Project getProjectById(String id)
  {
    Project project = new Project();

    for (Project p : projects)
    {
      if (p.getId() != null && p.getId().equals(id))
      {
        project = p;
        break;
      }
    }
    return project;
  }

  /**
   * Gets a String representation of the ProjectList.
   * @return a String containing information about all Project objects in the list - each Project object followed by a new line character
   */
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<projects.size(); i++)
    {
      returnStr += projects.get(i) +"\n";
    }
    return returnStr;
  }
}
