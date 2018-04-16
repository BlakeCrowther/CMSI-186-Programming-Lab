public class Clock{

  private int hours;
  private int minutes;
  private double seconds;
  private double timeslice;
  private double total_seconds;

  public Clock (double timeslice){
    this.hours = 0;
    this.minutes = 0;
    this.seconds = 0.0;
    this.timeslice = timeslice;
  }

  public void tick() {
    this.seconds = this.seconds + this.timeslice;
    while(this.seconds >= 60) {
      this.minutes ++;
      this.seconds = this.seconds - 60;
    }
    while(this.minutes >= 60) {
      this.hours ++;
      this.minutes = this.minutes - 60;
    }
  }

  public int getHour() {
    return this.hours;
  }

  public double getSeconds() {
    return this.seconds;
  }

  public double getMinutesAngle() {
    return (this.minutes * 6.0) + this.seconds * 0.1;
  }

  public double getHoursAngle() {
    return (this.hours * 30) + (this.minutes * 0.5) + (this.seconds * (0.5 / 60));
  }

  public String toString() {
    return this.hours + ":" + this.minutes + ":" + this.seconds;
  }

}
