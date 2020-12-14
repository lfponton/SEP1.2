import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable
{
  private ArrayList<Task> tasks;

  // Constructors
  public TaskList()
  {
    tasks = new ArrayList<Task>();
  }

  // Size, add and remove
  public int size()
  {
    return tasks.size();
  }

  public void addTask(Task task)
  {
    tasks.add(task);
  }

  public void addByIndex(int index, Task task)
  {
      tasks.add(index, task);
  }

  public void remove(Task task)
  {
    tasks.remove(task);
  }

  public void removeByIndex(int index)
  {
    if (index < tasks.size())
    {
      tasks.remove(index);
    }
  }

  // Several get methods
  public Task getTaskById(String id)
  {
    Task task = new Task();

    for (Task t : tasks)
    {
      if (t.getId() != null && t.getId().equals(id))
      {
        task = t;
        break;
      }
    }
    return task;
  }

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

  // Returns the sum of total hours for a TaskList
  public double totalHours()
  {
    double total = 0;
    for (Task t : tasks)
    {
      total += t.getTotalHours();
    }
    return total;
  }

  // Returns the sum of time estimates for a TaskList
  public double timeEstimates(double newEstimate)
  {
    double total = 0;
    for (Task t : tasks)
    {
      total += t.getTimeEstimate();
    }
    return total + newEstimate;
  }
  // toString
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
