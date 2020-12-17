import java.io.Serializable;

/**
 * A class representing a Project with an id, title, description and RequirementList object.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class Project implements Serializable
{
  private String id, title, description;
  private RequirementList requirements;

  /**
   * Three-argument constructor initializing a RequirementList
   * @param id the employee's first name
   * @param title the employee's last name
   * @param description the employee's role
   */
  public Project(String id, String title, String description)
  {
    this.id = id;
    this.title = title;
    this.description = description;
    requirements = new RequirementList();
  }
  /**
   * No-argument constructor initializing a RequirementList
   */
  public Project()
  {
    requirements = new RequirementList();
  }

  /**
   * Gets the Project's id.
   * @return the project's id
   */
  public String getId()
  {
    return id;
  }
  /**
   * Gets the Project's title.
   * @return the project's title
   */
  public String getTitle()
  {
    return title;
  }
  /**
   * Gets the Project's description.
   * @return the project's description
   */
  public String getDescription()
  {
    return description;
  }
  /**
   * Gets the Project's RequirementList.
   * @return the project's RequirementList
   */
  public RequirementList getRequirements()
  {
    return requirements;
  }

  /**
   * Sets the Project's RequirementList.
   * @param requirements what the project's requirements will be set to
   */
  public void setRequirements(RequirementList requirements)
  {
    this.requirements = requirements;
  }

  /**
   * Returns a string representation of the project.
   * @return a string representation of the project in the format:
   * "Project id: id
   * Title: title
   * Description: description"
   */
  public String toString()
  {
    String str = "-----------------------";
    return str + "\nProject id: " + id + "\nTitle: " + title + "\nDescription: " +
        description;
  }
}
