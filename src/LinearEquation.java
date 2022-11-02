public class LinearEquation {
  /* Instance Variables */
  private int x1;
  private int y1;
  private int x2;
  private int y2;


  public LinearEquation(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }


  public double distance() {
    return Math.round((Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)))) * 100.0) / 100.0;
  }


  public double yIntercept() {
    return Math.round((y1 - (x1 * ((double) (y2 - y1) / (x2 - x1))))*100.0)/100.0;
  }


  public double slope() {
    return Math.round(((double) (y2 - y1) / (x2 - x1)) * 100.0)/100.0;
  }


  public String equation() {

    // Variables
    String m = "";
    String sign = "";
    String c = "";
    String xValue = "x";
    double b = 0.0;
    int x = x2 - x1;
    int y = y2 - y1;

    // Logic
    b = yIntercept();

    if (y%x == 0) {
      m = String.valueOf((int) slope());
    } else {
      if (slope() > 0) {
        m = y + "/" + x;
      }
      if (slope() < 0) {
        m = "-" + y + "/" + Math.abs(x);
      }
    }

    if (b > 0) {
      sign = " + ";
      c = String.valueOf(Math.abs(b));
    } else if (b < 0) {
      sign = " - ";
      c = String.valueOf(Math.abs(b));
    } else {
      sign = "";
      c = "";
    }

    if(m.length() == 1){
      if (Integer.valueOf(m) == 1) {
        m = "";
      }
      if (Integer.valueOf(m) == -1) {
        m = "-";
      }
      if (Integer.valueOf(m) == 0) {
        m = "";
        xValue = "";
        sign = "";
      }
    }
    
    return "y = " + m + xValue + sign + c;
  }


  public String coordinateForX(double xValue) {
    return "Coordinate for X: (" + xValue + ", " + Math.round((slope()*xValue + yIntercept())*100.0)/100.0 + ")";
  }

  public double roundedToHundredth(double toRound) {
    return Math.round(toRound*100.0)/100.0;
  }


  public String lineInfo() {
    return "The original points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\nThe equation of the line between these points are: " + equation() + "\nThe slope of this line is: " + slope() + "\n The y intercept of the line is: " + yIntercept() + "\nThe distance between the two lines is: " + distance();
  }

}
