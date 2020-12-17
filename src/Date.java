import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * A class representing a Date with an day, month and year.
 * @author Agostina, Alina, Luis
 * @version 1.0
 */
public class Date implements Serializable
{
  private int day, month, year;

  /**
   * Three-argument constructor initializing a TaskList
   * @param day the date's day
   * @param month the date's month
   * @param year the date's year
   */
  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Gets the Date's day.
   * @return the date's day
   */
  public int getDay()
  {
    return day;
  }
  /**
   * Gets the Date's month.
   * @return the date's month
   */
  public int getMonth()
  {
    return month;
  }
  /**
   * Gets the Date's year.
   * @return the date's year
   */
  public int getYear()
  {
    return year;
  }


  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
      return false;

    Date other = (Date)obj;

    return day == other.day &&
        month == other.month &&
        year == other.year;
  }

  public static Date today()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);

    return new Date(currentDay, currentMonth, currentYear);
  }

  /**
   * Returns a string representation of the date.
   * @return a string representation of the date in the format: "day/month/year"
   */
  public String toString()

  {
    return day + "/" + month + "/" + year;
  }

}