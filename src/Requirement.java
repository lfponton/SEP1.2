import java.io.Serializable;

/**
 * A class representing a Requirement with an id, type, description, priority, status, totalHours, timeEstimate, deadline, teamMember and a TaskList object.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class Requirement implements Serializable
{
  private String id, type, description, priority, status;
  private double totalHours, timeEstimate;
  private Date deadline;
  private Employee teamMember;
  private TaskList tasks;

  /**
   * No-argument constructor initializing a TaskList
   */
  public Requirement() {
    tasks = new TaskList();
  }

  /**
   * Seven-argument constructor initializing a TaskList
   * @param id the requirement's id
   * @param status the requirement's status
   * @param description the requirement's description
   * @param deadline the requirement's deadline
   * @param timeEstimate the requirement's timeEstimate
   * @param totalHours the requirement's totalHours
   * @param teamMember the requirement's teamMember
   */
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

  /**
   * Gets the Requirement's id.
   * @return the requirement's id
   */
  public String getId()
  {
    return id;
  }

  /**
   * Gets the Requirement's description.
   * @return the requirement's description
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Gets the Requirement's status.
   * @return the requirement's status
   */
  public String getStatus()
  {
    return status;
  }

  /**
   * Gets the Requirement's tasks.
   * @return the requirement's tasks
   */
  public TaskList getTasks()
  {
    return tasks;
  }

  /**
   * Gets the Requirement's deadline.
   * @return the requirement's deadline
   */
  public Date getDeadline()
  {
    return deadline;
  }

  /**
   * Gets the Requirement's teamMember.
   * @return the requirement's teamMember
   */
  public Employee getTeamMember()
  {
    return teamMember;
  }

  /**
   * Gets the Requirement's totalHours.
   * @return the requirement's totalHours
   */
  public double getTotalHours()
  {
    return totalHours;
  }

  /**
   * Gets the Requirement's timeEstimates.
   * @return the requirement's timeEstimates
   */
  public double getTimeEstimate()
  {
    return timeEstimate;
  }

  /**
   * Gets the Requirement's type.
   * @return the requirement's type
   */
  public String getType()
  {
    return type;
  }

  /**
   * Gets the Requirement's priority.
   * @return the requirement's priority
   */
  public String getPriority()
  {
    return priority;
  }


  /**
   * Sets the Requirement's tasks.
   * @param tasks the requirement's tasks
   */
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

  /**
   * Compares requirement's timeEstimates to the tasks time estimates
   * @param oldEstimate the existing task estimates
   * @param newEstimate the new time estimates for the task
   * @return boolean true if the requirement's timeEstimates are less than the tasks' time estimates
   */
  public boolean tooManyHours(double oldEstimate, double newEstimate)
  {
    double difference = newEstimate - oldEstimate;
    return getTasks().timeEstimates(difference) > getTimeEstimate();
  }

  /**
   * Sets the total task hours to the Requirement.
   */
  public void setHours()
  {
    totalHours = getTasks().totalHours();
  }

  /**
   * Returns a string representation of the requirement.
   * @return a string representation of the requirement in the format:
   * "Requirement id: id
   * Priority: title
   * Status: status
   * Type: type
   * Description: description
   * Deadline: deadline
   * Team Member: teamMember
   * Total Hours: totalHours
   * Time Estimate: timeEstimate"
   */
  public String toString()
  {
    String str = "-----------------------";
    return str + "\nRequirement id: " + id + "\nPriority: " + priority
        + "\nStatus: " + status + "\nType: " + type +"\nDescription: "
        + description + "\nDeadline: " + deadline
        + "\nTeam Member: " + teamMember + "\nTotal Hours: " + totalHours
        + "\nTime Estimate: " + timeEstimate;
  }

}

