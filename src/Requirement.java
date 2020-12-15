import java.io.Serializable;

public class Requirement implements Serializable
{
  private String id, type, description, priority, status, projectId;
  private double totalHours, timeEstimate;
  private Date deadline;
  private Employee teamMember;
  private TaskList tasks;

  // Constructors
  public Requirement() {}
  public Requirement(String id, String status, String description, Date deadline, double timeEstimate, double totalHours, Employee teamMember)
  {
    this.id = id;
    this.status = status;
    this.description = description;
    this.deadline = deadline;
    this.timeEstimate = timeEstimate;
    this.totalHours = totalHours;
    this.teamMember = teamMember;
    tasks = new TaskList();
  }
// Remove this constructor
  public Requirement(String id, String type, String description,
      String priority, String status, double totalHours, double timeEstimate,
      Date deadline, Employee teamMember)
  {
    this.id = id;
    this.type = type;
    this.description = description;
    this.priority = priority;
    this.status = status;
    this.totalHours = totalHours;
    this.timeEstimate = timeEstimate;
    this.deadline = deadline;
    this.teamMember = teamMember;
    this.tasks = new TaskList();
  }

  // Getters
  public String getId()
  {
    return id;
  }

  public String getDescription()
  {
    return description;
  }

  public String getStatus()
  {
    return status;
  }

  public TaskList getTasks()
  {
    return tasks;
  }

  public Date getDeadline()
  {
    return deadline;
  }

  public Employee getTeamMember()
  {
    return teamMember;
  }

  public double getTotalHours()
  {
    return totalHours;
  }

  public double getTimeEstimate()
  {
    return timeEstimate;
  }

  public String getType()
  {
    return type;
  }

  public String getPriority()
  {
    return priority;
  }


  // Setters
  public void setTasks(TaskList tasks)
  {
    this.tasks = tasks;
  }


  // Check if all tasks are done
  public boolean tasksDone()
  {
    TaskList tasks = getTasks();
    int size = tasks.size();
    int count = 0;
    boolean areDone = false;

    if (size != 0)
    {
      for (int i = 0; i <= size; i++)
      {
        if (tasks.getTask(i) != null && tasks.getTask(i).getStatus()
            .equals("Ended"))
        {
          count++;
        }
      }
      if (size == count)
      {
        areDone = true;
      }
    }
    return areDone;
  }

  // Compare reqs hours to tasks hours
  public boolean tooManyHours(double oldEstimate, double newEstimate)
  {
    double difference = newEstimate - oldEstimate;
    return getTasks().timeEstimates(difference) > getTimeEstimate();
  }

  public void setHours()
  {
    totalHours = getTasks().totalHours();
  }
  // toString
  public String toString()
  {
    String str = "-----------------------";
    return str + "\nRequirement id: " + id + "\nPriority: " + priority
        + "\nStatus: " + status + "\nType: " + type +"\nDescription: "
        + description + "\nDeadline: " + deadline
        + "\nTeam Member: " + teamMember + "\nTotal Hours: " + totalHours
        + "\nTime Estimate: " + timeEstimate + "\nProject id: " + projectId + "\n";
  }

}

