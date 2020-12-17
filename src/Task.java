import java.io.Serializable;

/**
 * A class representing a Task with an id, description, status, totalHours, timeEstimate, deadline, teamMember
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class Task implements Serializable
{
  private String id, description, status;
  private double totalHours, timeEstimate;
  private Date deadline;
  private Employee teamMember;

  /**
   * Seven-argument constructor initializing a TaskList
   * @param id the requirement's id
   * @param status the requirement's status
   * @param description the requirement's description
   * @param deadline the requirement's timeEstimate
   * @param timeEstimate the requirement's totalHours
   * @param totalHours the requirement's deadline
   * @param teamMember the requirement's teamMember
   */
  public Task(String id, String status,
      String description, double timeEstimate, double totalHours, Date deadline,
      Employee teamMember)
  {
    this.id = id;
    this.description = description;
    this.status = status;
    this.deadline = deadline;
    this.timeEstimate = timeEstimate;
    this.totalHours = totalHours;
    this.teamMember = teamMember;
  }

  /**
   * No-argument constructor initializing the RequirementList.
   */
  public Task() {}

  /**
   * Gets the Task's id.
   * @return the task's id
   */
  public String getId()
  {
    return id;
  }

  /**
   * Gets the Task's description.
   * @return the task's description
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Gets the Task's status.
   * @return the task's status
   */
  public String getStatus()
  {
    return status;
  }

  /**
   * Gets the Task's totalHours.
   * @return the task's totalHours
   */
  public double getTotalHours()
  {
    return totalHours;
  }

  /**
   * Gets the Task's timeEstimate.
   * @return the task's timeEstimate
   */
  public double getTimeEstimate()
  {
    return timeEstimate;
  }

  /**
   * Gets the Task's deadline.
   * @return the task's deadline
   */
  public Date getDeadline()
  {
    return deadline;
  }

  /**
   * Gets the Task's teamMember.
   * @return the task's teamMember
   */
  public Employee getTeamMember() {return teamMember;}

  /**
   * Returns a string representation of the task.
   * @return a string representation of the task in the format:
   * "Task id: id
   * Status: status
   * Description: description
   * Deadline: deadline
   * Team Member: teamMember
   * Total Hours: totalHours
   * Time Estimate: timeEstimate"
   */
  public String toString()
  {
    String str = "-----------------------";
    return str + "Task id: " + id
        + "\nStatus: " + status + "\nDescription: "
        + description + "\nDeadline: " + deadline
        + "\nTeam Member: " + teamMember + "\nTotal Hours: " + totalHours
        + "\nTime Estimate: " + timeEstimate;
  }
}
