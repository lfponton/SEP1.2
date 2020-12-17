import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Task objects.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class TaskList implements Serializable
{
  private ArrayList<Task> tasks;

  /**
   * No-argument constructor initializing the Tasklist.
   */
  public TaskList()
  {
    tasks = new ArrayList<Task>();
  }

  /**
   * Gets how many Tasl objects are in the list.
   * @return the number of Task objects in the list
   */
  public int size()
  {
    return tasks.size();
  }

  /**
   * Adds a Task to the list
   * @param task the requirement to add to the list
   */
  public void addTask(Task task)
  {
    tasks.add(task);
  }

  /**
   * Adds a Task to the list by index
   * @param index index on the list
   * @param task the task to add to the list
   */
  public void addByIndex(int index, Task task)
  {
      tasks.add(index, task);
  }

  /**
   * Removes a Task from the list by index
   * @param index index on the list
   */
  public void removeByIndex(int index)
  {
    if (index < tasks.size())
    {
      tasks.remove(index);
    }
  }

  /**
   * Gets a Task object from position index from the list.
   * @param index the position in the list of the Task object
   * @return the Task object at position index if one exists, else null
   */
  public Task getTask(int index)
  {
    if (index < tasks.size())
    {
      return tasks.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Sums the totalHours for all tasks in the TaskList object
   * @return a double with the sum of total hours for the tasks in a TaskList
   */
  public double totalHours()
  {
    double total = 0;
    for (Task t : tasks)
    {
      total += t.getTotalHours();
    }
    return total;
  }

  /**
   * Sums the timeEstimates for all tasks in the TaskList object
   * @param newEstimate the new time estimate selected by the use
   * @return a double with the sum of timeEstimates for the tasks in a TaskList
   */
  public double timeEstimates(double newEstimate)
  {
    double total = 0;
    for (Task t : tasks)
    {
      total += t.getTimeEstimate();
    }
    return total + newEstimate;
  }

  /**
   * Gets a String representation of the TaskList.
   * @return a String containing information about all Task objects in the list - each Task object followed by a new line character
   */
  public String toString()
  {
    String str = "";
    for (Task t : tasks)
    {
      str += t.toString();
    }
    return str;
  }
}
