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

    double open;
    double hx;
    double lx;
    double close;
    int numShares;
    double adjustedClose;

    String line = new String();
    line = sc.nextLine();
    String[] lineA = new String[line.length()];
    lineA = line.split("\t");

    data.put(lineA[0], new CompanyData(lineA[0]));
    // System.out.println("entryset: " + data.entrySet());


    while (sc.hasNextLine()) {

      String currentLine = new String();
      currentLine = sc.nextLine();
      String[] lineArr = new String[currentLine.length()];
      lineArr = currentLine.split("\t");


      if (data.containsKey(lineArr[0])) {

        String date = lineArr[1];
        open = Double.valueOf(lineArr[2]);
        hx = Double.valueOf(lineArr[3]);
        lx = Double.valueOf(lineArr[4]);
        close = Double.valueOf(lineArr[5]);
        numShares = Integer.valueOf(lineArr[6]);
        adjustedClose = Double.valueOf(lineArr[7]);

        //calculate crazy days
        //(Hx-Lx)/Hx >= 15%
        double percent = (hx - lx)/hx;
        // System.out.println("percent = " + percent);
        if (percent >= 0.15) {
          data.get(lineArr[0]).addCrazyDay(date, percent);
          // data.get(lineArr[0]).getCrazyDays();
        }


        //calculate split

      } else {
        // System.out.println("current ticker: " + lineArr[0]);

        //create new obj

        data.put(lineArr[0], new CompanyData(lineArr[0]));
        // System.out.println("created new obj: " + data.get(lineArr[0]) + "\n");
        // CompanyData company = new CompanyData(lineArr[0]);
      }


    }

    for (CompanyData company : data.values()) {
      System.out.println("Processing: " + company.getCompany());
      company.getCrazyDays();
    }
    // System.out.println("entryset: " + data.entrySet());
  }
}
