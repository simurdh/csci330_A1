/* Hannah Simurdak
04/14/2019
CSCI 330 Assignment 1
*/



import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DataMining {

  public static void main(String[] args) throws FileNotFoundException {

    File f = new File("Stockmarket-1990-2015.txt");
    Scanner sc = new Scanner(f);

    while (sc.hasNextLine()) {

      String currentLine = new String();
      currentLine = sc.nextLine();
      String[] lineArr = new String[currentLine.length()];
      lineArr = currentLine.split("\t");

      CompanyData data = new CompanyData(lineArr[0]);
      System.out.println("lineArr[0] = " + lineArr[0]);

      if (lineArr[0] == data.getCompany() && sc.hasNextLine()) {

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
        //print prev obj

        //create new obj
        CompanyData data = new CompanyData(lineArr[0]);
      }
    }
  }
}
