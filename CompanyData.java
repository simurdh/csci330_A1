
import java.util.*;

public class CompanyData {

  //Instance Variables
  String ticker;
  HashMap<String, Double> crazyD = new HashMap<>();

  //Constructor
  public CompanyData(String ticker) {
    this.ticker = ticker;
  }

  public String getCompany() {
    return ticker;
  }

  //add crazy days
  public void addCrazyDay(String date, double p) {
    crazyD.put(date, p);
    System.out.println("crazy day added in " + ticker);

  }

  //return crazy days
  public void getCrazyDays() {
    for (Map.Entry<String, Double> day : crazyD.entrySet()) {
      System.out.println("Crazy day: " + day.getKey() + "\t" + day.getValue());
    }
  }

}
