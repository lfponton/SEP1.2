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
  public void removeTask(Task task)
  {
    tasks.remove(task);
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
    if(index < tasks.size())
    {
      return tasks.get(index);
    }
    else
    {
      return null;
    }
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
