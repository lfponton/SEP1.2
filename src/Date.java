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

  public Date()
  {
    day = Date.today().day;
    month = Date.today().month;
    year = Date.today().month;
  }

  public void setDay(int day)
  {
    //This could just be if day is greater than daysInMonth
    if (month != 0 && (day > daysInMonth()))
    {
      throw new IllegalDateException(
          "There are not as many days in the month.");
    }
    else if (day <= 0)
      throw new IllegalDateException("There cannot be 0 or negative days.");

    this.day = day;
  }

  public void setMonth(int month)
  {
    if (month > 12)
      throw new IllegalDateException("There are only 12 months in a year.");
    else if (month <= 0)
      throw new IllegalDateException("There cannot be 0 or negative months.");
    this.month = month;
}

  public void setYear(int year)
  {
    this.year = year;
  }

  public int daysInMonth()
  {
    int daysInMonth = 0;

    if (month == 4 ||
        month == 6 ||
        month == 9 ||
        month == 11)
      daysInMonth = 30;

    else if (month == 2)
      if (isLeapYear())
        daysInMonth = 29;
      else
        daysInMonth = 28;

    else
      daysInMonth = 31;

    return daysInMonth;
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

  // DO THE SAME FOR AFTER IN CASE THE DATE IS START DATE
  public boolean isBefore(Date date)
  {
    boolean isBefore = false;
    if (year < date.year)
      isBefore = true;
    else if(year == date.year)
    {
      if (month < date.month)
        isBefore = true;
      else if (month == date.year)
      {
        if (day < date.day)
          isBefore = true;
      }
    }
    else
      throw new IllegalDateException(
          "The deadline cannot be before the start date.");
    return isBefore;
  }

  public String toString()

  {
    return day + "/" + month + "/" + year;
  }

  public boolean isLeapYear()
  {
    if (year % 4 == 0)
    {
      if (year % 100 == 0 && year % 400 == 0)
      {
        return true;
      }
      else if (year % 100 == 0 && year % 400 != 0)
      {
        return false;
      }
      else
        return true;
    }
    else
      return false;
  }
}