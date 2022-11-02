import java.util.Scanner;

public class LinearEquationRunner {
  public static void main(String[] args) {
    // Variables
    String coordinate1 = "";
    String coordinate2 = "";
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    // Main Logic

    // Welcome - Scanning input loop
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to Coordinate Calculator!");
    while (true) {
      System.out.print("Enter coordinate 1: ");
      String coord1 = scan.nextLine();
      if (coord1.indexOf(" ") > 0 && coord1.indexOf(")") > 0 && coord1.indexOf("(") > -1 && coord1.indexOf(",") > 0) {
        coordinate1 = coord1;
        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();
        if (coord2.indexOf(" ") > 0 && coord2.indexOf(")") > 0 && coord2.indexOf("(") > -1 && coord2.indexOf(",") > 0) {
          coordinate2 = coord2;
          break;
        }
      }
      System.out.println("Please enter a valid coordinate.");
    }

    // Derive x1, y1, x2, y2 from string input
    x1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf("(") + 1, coordinate1.indexOf(",")));
    y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(" ") + 1, coordinate1.indexOf(")")));
    x2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf("(") + 1, coordinate2.indexOf(",")));
    y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(" ") + 1, coordinate2.indexOf(")")));

    //Detects if it's on a verticle line, creates a new LinearEquation object if it isn't
    if (x1 == x2){
      System.out.println("These points are on the verticle line: x = " + x1);
    }else{
      LinearEquation newEquation = new LinearEquation(x1, y1, x2, y2);
      System.out.println(newEquation.lineInfo());
      System.out.print("Enter a value for x: ");
      double value = scan.nextDouble();
      System.out.println(newEquation.coordinateForX(value));
    }


  }
}
