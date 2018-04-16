public class ClockSim {

  public static void main ( String[] args) {

    double timeslice = 60.0;
    double angle = 0;

    if ( args.length == 2 ) {
      timeslice = Double.parseDouble(args[1]);
    } else if ( args.length < 1 || args.length > 2 ) {
      throw new IllegalArgumentException("No angle inputed or too many arguments.");
    }
    angle = Double.parseDouble(args[0]);
    if( angle < 0 || angle > 360 || timeslice > 1800 ) {
      throw new IllegalArgumentException( "Angle must be a non-negative real number less than 360 degrees, and time slice must be less than 1800 seconds." );
    }

    Clock c = new Clock( timeslice );
    double theta_angle = 0.0;
    double accuracy = 5.5 / 60 * timeslice / 2;





    for(int i = 0; i < 43200 / timeslice ; i++) {
      theta_angle = Math.abs(c.getHoursAngle() - c.getMinutesAngle());
      if(angle == theta_angle || theta_angle < angle && angle < theta_angle + accuracy || theta_angle > angle && angle > theta_angle - accuracy ) {
        System.out.println(c.toString());
      }
      c.tick();
    }
  }
}
