public class Riemann {
  public static void main (String[] args) {
    double lower;
    double upper;
    double[] coefficient = new double[args.length - 2];   //Declares array for coefficients
    if( args.length < 3 ) {                             //Checks to see if theres enough args
      System.out.println("Insufficient Data");
      return;
    } else {
      lower = Double.parseDouble(args[args.length - 2]);    //If there is enough parses lower and upper bound
      upper = Double.parseDouble(args[args.length - 1]);
      if( lower > upper ) {                               // If Lower bound is greater than upper bound outputs error message
        System.out.println("Inappropriate bounds");
        return;
      } else {
        for( int i = 0; i < args.length - 2; i++) {       //Creates array of coefficients
          coefficient[i] = Double.parseDouble(args[i]);
        }
      }
    }
    double accuracy = 0.0001;               //Accuracy variable
    double currentArea = 0.0;
    double sumOfArea = 0.0;
    double currentHeight = 0.0;
    double subIntervals = 2.0;
    double currentBase = (upper - lower) / 2.0;       //Delta x or current base size starting at 2 subIntervals
    double recArea = 0.0;
    double previousArea = 0.0;
    do {
      for(int i = 1; i <= subIntervals; i++) {          //For loop for number of subIntervals
        for(int j = 0; j < coefficient.length; j++) {   //for loop to find current height by calculating polynomial
          currentHeight += (coefficient[j] * Math.pow((((currentBase * i) + lower) - (currentBase / 2.0)), j)); //current polynomial constant * x, which is midpoint of current subinterval ^ power of the position of the current coefficient
        }
        recArea = currentHeight * currentBase; //Area of the current subIntervals
        sumOfArea += recArea; //Adds area of current subInterval to total area of all subintervals
        currentHeight = 0.0; //resets the height
      }
      previousArea = currentArea;
      currentArea = sumOfArea;
      currentBase = currentBase / 2.0; //divdes current base to produce a smaller delta x for twice as many subintervals
      sumOfArea = 0.0; //resets sum of all subintervals
      subIntervals = subIntervals * 2.0; //increases subinterval amount to twice as much
    } while(Math.abs((previousArea - currentArea)) > accuracy);  //continues do while loop until the absolute value of the difference between previous area of 1/2 the amount of subintervals of current area, and current area, is less than 0.001
    System.out.println(currentArea); //outputs area of polynomial using midpoint formula
  }
}
