import java.io.Serializable;

public class Task implements Serializable
{
  private String id, description, status, requirementId;
  private double totalHours, timeEstimate;
  private Date deadline;
  private Employee teamMember;

  // Constructors
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

  public Task() {}

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

  public double getTotalHours()
  {
    return totalHours;
  }

  public double getTimeEstimate()
  {
    return timeEstimate;
  }

  public Date getDeadline()
  {
    return deadline;
  }

  // toString
  public String toString()
  {
    String str = "-----------------------";
    return str + "\nRequirement id: " + requirementId + "\nTask id: " + id
        + "\nStatus: " + status + "\nDescription: "
        + description + "\nDeadline: " + deadline
        + "\nTeam Member: " + teamMember + "\nTotal Hours: " + totalHours
        + "\nTime Estimate: " + timeEstimate;
  }
}
