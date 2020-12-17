import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Requirement objects.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class RequirementList implements Serializable
{
  private ArrayList<Requirement> requirements;

  /**
   * No-argument constructor initializing the RequirementList.
   */
  public RequirementList()
  {
    requirements = new ArrayList<Requirement>();
  }

  /**
   * Gets how many Requirement objects are in the list.
   * @return the number of Requirement objects in the list
   */
  public int size()
  {
    return requirements.size();
  }

  /**
   * Adds a Requirement to the list
   * @param requirement the requirement to add to the list
   */
  public void addRequirement(Requirement requirement)
  {
    requirements.add(requirement);
  }
  /**
   * Adds a Requirement to the list by index
   * @param currentIndex index on the list
   * @param requirement the requirement to add to the list
   */
  public void add(int currentIndex, Requirement requirement)
  {
    requirements.add(currentIndex, requirement);
  }

  /**
   * Removes a Requirement from the list
   * @param requirement the requirement to add to the list
   */
  public void removeRequirement(Requirement requirement)
  {
    requirements.remove(requirement);
  }
  /**
   * Removes a Requirement from the list by index
   * @param index index on the list
   */
  public void removeReqByIndex(int index)
  {
    requirements.remove(index);
  }

  /**
   * Gets a Requirement object from position index from the list.
   * @param index the position in the list of the Requirement object
   * @return the Requirement object at position index if one exists, else null
   */
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

  /**
   * Gets an Requirement object from position index from the list.
   * @param id the requirement's id
   * @return the Requirement object with the selected id
   */
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

  /**
   * Gets a String representation of the RequirementList.
   * @return a String containing information about all Requirement objects in the list - each Requirement object followed by a new line character
   */
  public String toString()
  {
    String str = "";
    for (Requirement r : requirements)
    {
     str += r.toString();
    }
    return str;
  }
}
