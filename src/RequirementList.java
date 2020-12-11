import java.io.Serializable;
import java.util.ArrayList;

public class RequirementList implements Serializable
{
  private ArrayList<Requirement> requirements;

  // Constructors
  public RequirementList()
  {
    requirements = new ArrayList<Requirement>();
  }

  // Size, add and remove
  public int size()
  {
    return requirements.size();
  }
  public void addRequirement(Requirement requirement)
  {
    requirements.add(requirement);
  }
  public void removeRequirement(Requirement requirement)
  {
    requirements.remove(requirement);
  }

  public void removeReqByIndex(int index)
  {
    requirements.remove(index);
  }
  // Several get methods
  // Return the Requirement object at index if one exists,
  // else return null
  public Requirement getRequirement(int index)
  {
    if(index<requirements.size())
    {
      return requirements.get(index);
    }
    else
    {
      return null;
    }
  }

  public Requirement getRequirementById(String id)
  {
    Requirement requirement = new Requirement();

    for (Requirement r : requirements)
    {
      if (r.getId() != null && r.getId().equals(id))
      {
        requirement = r;
        break;
      }
    }
    return requirement;
  }

  // toStrimg
  public String toString()
  {
    String str = "";
    for (Requirement r : requirements)
    {
     str += r.toString();
    }
    return str;
  }

  public void add(int currentIndex, Requirement requirement)
  {
    requirements.add(currentIndex, requirement);
  }
}
