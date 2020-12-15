import java.io.Serializable;

public class Project implements Serializable
{
  private String id, title, description;
  private RequirementList requirements;

  // Constructors
  public Project(String id, String title, String description)
  {
    this.id = id;
    this.title = title;
    this.description = description;
    requirements = new RequirementList();
  }

  public Project()
  {
    requirements = new RequirementList();
  }

  // Getters
  public String getId()
  {
    return id;
  }
  public String getTitle()
  {
    return title;
  }
  public String getDescription()
  {
    return description;
  }
  public RequirementList getRequirements()
  {
    return requirements;
  }

  // Setters
  public void setRequirements(RequirementList requirements)
  {
    this.requirements = requirements;
  }


  // toString
  public String toString()
  {
    String str = "-----------------------";
    return str + "\nProject id: " + id + "\nTitle: " + title + "\nDescription: " +
        description;
  }
}
