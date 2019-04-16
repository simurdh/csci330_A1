/* Hannah Simurdak
04/14/2019
CSCI 330 Assignment 1
*/


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DataMining {

  public static void main(String[] args) {

    Scanner sc = null;

    try {
      File f = new File(args[1]); //where is file passed in? try catch?
      sc = new Scanner(f);
    } catch (FileNotFoundException exc) {
      System.out.println("Could not find file " + args[1]);
    }


    while (sc.hasNextLine()) {

      CompanyData data = new CompanyData(sc.next());
      String currentLine = sc.nextLine();


      while (currentLine.contains(data.getCompany())) {

        Scanner line = new Scanner(currentLine);

        line.next();
        String date = line.next();
        double open = line.nextDouble();
        double hx = line.nextDouble();
        double lx = line.nextDouble();
        double close = line.nextDouble();

        System.out.println("date = " + date);

        //calculate crazy days


        currentLine = sc.nextLine();
      }

    }

  }
}
