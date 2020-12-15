import java.io.Serializable;
import java.util.GregorianCalendar;

public class Date implements Serializable
{
  private int day, month, year;

  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

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

  public String toString()

  {
    return day + "/" + month + "/" + year;
  }

}