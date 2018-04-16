public class Riemann2 {
  public static void main (String[] args) {
    double lower;
    double upper;
    double[] coefficient = new double[args.length - 2];
    if( args.length < 3 ) {
      System.out.println("Insufficient Data");
      return;
    } else {
      lower = Double.parseDouble(args[args.length - 2]);
      upper = Double.parseDouble(args[args.length - 1]);
      if( lower > upper ) {
        System.out.println("Inappropriate bounds");
        return;
      } else {
        for( int i = 0; i < args.length - 2; i++) {
          coefficient[i] = Double.parseDouble(args[i]);
        }
      }
    }
    double accuracy = 0.0001;
    double currentArea = 0.0;
    double sumOfArea = 0.0;
    double currentHeight = 0.0;
    double subIntervals = 2.0;
    double currentBase = (upper - lower) / 2;
    double recArea = 0.0;
    double previousArea = 0.0;
    do {
      for(int i = 1; i < subIntervals + 1; i++) {
        for(int j = 0; j < coefficient.length; j++) {
          currentHeight += (coefficient[j] * Math.pow((double)((currentBase * i) - (currentBase / 2.0)), j));
        }
        recArea = currentHeight * currentBase;
        sumOfArea += recArea;
        currentHeight = 0.0;
      }
      previousArea = currentArea;
      currentArea = sumOfArea;
      currentBase = currentBase / 2.0;
      sumOfArea = 0.0;
      subIntervals = subIntervals * 2.0;
    } while(Math.abs((previousArea - currentArea)) > accuracy);
    System.out.println(currentArea);
  }
}
