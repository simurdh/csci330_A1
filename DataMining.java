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


    while (sc.hasNextLine()) {

      String currentLine = new String();
      currentLine = sc.nextLine();
      String[] lineArr = new String[currentLine.length()];
      lineArr = currentLine.split("\t");

      data.put(lineArr[0], new CompanyData(lineArr[0]));
      System.out.println("lineArr[0] = " + lineArr[0]);

      if (data.containsKey(lineArr[0]) && sc.hasNextLine()) {

        String date = lineArr[1];
        double open = Double.valueOf(lineArr[2]);
        double hx = Double.valueOf(lineArr[3]);
        double lx = Double.valueOf(lineArr[4]);
        double close = Double.valueOf(lineArr[5]);
        int numShares = Integer.valueOf(lineArr[6]);
        double adjustedClose = Double.valueOf(lineArr[7]);

        //calculate crazy days

        //calculate split

      } else {
        //create new obj
        data.put(lineArr[0], new CompanyData(lineArr[0]));

        // CompanyData company = new CompanyData(lineArr[0]);
      }
    }
  }
}
