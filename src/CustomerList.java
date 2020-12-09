import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
  private ArrayList<Customer> customers;

  public CustomerList()
  {
    customers = new ArrayList<Customer>();
  }
}
