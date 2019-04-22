/* Hannah Simurdak
04/14/2019
CSCI 330 Assignment 1
*/



import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataMining {

  public static void main(String[] args) throws FileNotFoundException {
    File f = new File("Stockmarket-1990-2015.txt");
    Scanner sc = new Scanner(f);

    HashMap<String, CompanyData> data = new HashMap<>();
    ArrayList<String> tickerList = new ArrayList<>();

    double close;
    double hx;
    double lx;
    int numShares;
    double adjustedClose;
    String split;

    String line = new String();
    line = sc.nextLine();
    String[] lineA = new String[line.length()];
    lineA = line.split("\t");

    data.put(lineA[0], new CompanyData(lineA[0]));
    tickerList.add(lineA[0]);
    // System.out.println("entryset: " + data.entrySet());

    Double open = Double.valueOf(lineA[5]);

    while (sc.hasNextLine()) {



      String currentLine = new String();
      currentLine = sc.nextLine();
      String[] lineArr = new String[currentLine.length()];
      lineArr = currentLine.split("\t");


      if (!data.containsKey(lineArr[0])) {
        data.put(lineArr[0], new CompanyData(lineArr[0]));
        tickerList.add(lineArr[0]);
      }

      String date = lineArr[1];
      close = Double.valueOf(lineArr[5]);

      split = calcSplitDay(close, open);
      if (split != null) {
        String info = "" + split + " split on " + date + " " + close + " --> " + open;
        data.get(lineArr[0]).addSplitDay(date, info);
      }

      hx = Double.valueOf(lineArr[3]);
      lx = Double.valueOf(lineArr[4]);
      open = Double.valueOf(lineArr[2]);
      numShares = Integer.valueOf(lineArr[6]);
      adjustedClose = Double.valueOf(lineArr[7]);

      //calculate crazy days
      //(Hx-Lx)/Hx >= 15%
      double percent = (hx - lx)/hx;
      // System.out.println("percent = " + percent);
      if (percent >= 0.15) {
        percent = percent*100;
        data.get(lineArr[0]).addCrazyDay(date, Math.round(percent*100.0)/100.0);
        // data.get(lineArr[0]).getCrazyDays();
      }
    }
    Collections.sort(tickerList);
    System.out.println(tickerList);

    for (String company : tickerList) {
      System.out.println("Processing: " + company);
      System.out.println("======================");
      data.get(company).getCrazyDays();
      data.get(company).getSplitDays();
    }

    // for (CompanyData company : data.values()) {
    //   System.out.println("Processing: " + company.getCompany());
    //   System.out.println("======================");
    //   company.getCrazyDays();
    //   company.getSplitDays();
    // }
    // System.out.println("entryset: " + data.entrySet());
  }

  public static String calcSplitDay(Double C, Double O) {
    if (Math.abs(C/O - 2.0) < 0.05) {
      return "2:1";
    } else if (Math.abs(C/O - 3.0) < 0.05) {
      return "3:1";
    } else if (Math.abs(C/O - 1.5) < 0.05) {
      return "3:2";
    } else {
      return null;
    }
  }
}
