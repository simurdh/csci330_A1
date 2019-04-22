/* Hannah Simurdak
04/22/2019
CSCI 330 Assignment 1
*/

import java.util.*;

public class CompanyData {

  //Instance Variables
  private String ticker;
  private LinkedHashMap<String, Double> crazyD = new LinkedHashMap<>();
  private LinkedHashMap<String, String> splitD = new LinkedHashMap<>();

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
  }

  //return crazy days
  public void getCrazyDays() {

    //calculate craziest day
    double crazyVal = 0.0;
    String crazyString = "";
    int count = 0;

    for (Map.Entry<String, Double> day : crazyD.entrySet()) {
      System.out.println("Crazy day: " + day.getKey() + "\t" + day.getValue());
      count++;
      if (day.getValue() > crazyVal) {
        crazyVal = day.getValue();
        crazyString = day.getKey();
      }
    }

    System.out.println("Total crazy days = " + count);
    if (count != 0) {
      System.out.println("craziest day : " + crazyString + "\t" + crazyVal + "\n");
    } else {
      System.out.println("");
    }
  }

  //add split days
  public void addSplitDay(String date, String info) {
    splitD.put(date, info);
  }

  public void getSplitDays() {

    int count = 0;

    for (Map.Entry<String, String> day : splitD.entrySet()) {
      System.out.println(day.getValue());
      count++;
    }
    System.out.println("Total number of splits: " + count + "\n");
  }
}
