import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable
{
  private ArrayList<Project> projects;

  // Constructors
  public void addProject(int index, Project project)
  {
    projects.add(index, project);
  }

  public ProjectList()
  {
    projects = new ArrayList<Project>();
  }

  // Size, add, and remove
  public int size()
  {
    return projects.size();
  }
  public void addProject(Project project)
  {
    projects.add(project);
  }
  public void removeProject(Project project)
  {
    projects.remove(project);
  }
  public void removeProjectByIndex(int index)
  {
    if (index < projects.size())
    {
      projects.remove(index);
    }
  }

  // Several get methods
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

  // toString
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
