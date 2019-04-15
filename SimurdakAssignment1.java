/* Hannah Simurdak
04/14/2019
CSCI 330 Assignment 1
*/


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DataMining {

  public static void main(String[] args) {

    File f = new File(args[1]); //where is file passed in? try catch?
    Scanner sc = new Scanner(f);

    while (sc.hasNextLine()) {

      CompanyData data = new CompanyData(sc.next);
      String currentLine = sc.nextLine();


      while (currentLine.contains(data.getCompany)) {

        Scanner line = new Scanner(currentLine);

        line.next();
        String date = line.next();
        double open = line.nextDouble();
        double hx = line.nextDouble();
        double lx = line.nextDouble();
        double close = line.nextDouble();

        //calculate crazy days


        String currentLine = sc.nextLine();
      }

    }

  }
}

public class CompanyData {

  //Instance Variables
  String ticker;

  //Constructor
  public CompanyData(String ticker) {
    this.ticker = ticker;
  }

  public String getCompany() {
    return ticker;
  }

  //add crazy day

  //return crazy days

}
