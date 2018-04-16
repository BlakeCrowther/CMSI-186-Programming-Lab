public class WhatsTheDate {

  public static String WhatsTheDate(int month, int day, int year, int daysAdded) {
    if( isValid(month, day, year) == true && daysAdded > 0) {
      while(daysAdded > 0 ) {
        day++;
        if(day > daysInMonth(month, year)) {
          if(month == 12) {
            year++;
            month = 1;
            day = 1;
          } else {
            month++;
            day = 1;
          }
        }
        daysAdded--;
      }
    } else {
      throw new IllegalArgumentException();
    }
    return Integer.toString(month) + " " + Integer.toString(day) + " " + Integer.toString(year);
  }

  public static int daysInMonth(int month, int year ) {
    int days = 0;
    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
        days = 31;
    } else if(month == 2) {
      if(isLeap(year) == true) {
        days = 29;
      } else {
        days = 28;
      }
    } else if(month == 4 || month == 6 || month == 9 || month == 10 || month == 11) {
      days = 30;
    }
    return days;
  }

  public static boolean isValid ( int month, int day, int year ) {
    boolean result = false;
    if( year > 1 ) {
      if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
        if( day <= 31 && day >= 1 ) {
          result = true;
        }
      } else if(month == 2) {
        if(isLeap(year) == true) {
          if(day <= 29 && day >= 1) {
          result = true;
          }
        } else {
          if(day <= 28 && day >= 1) {
          result = true;
          }
        }
      } else if(month == 4 || month == 6 || month == 9 || month == 10 || month == 11) {
        if( day <= 30 && day >= 1 ) {
        result = true;
        }
      }
    }
    return result;
  }

  public static boolean isLeap(int year) {
		boolean result = false;
		if( year % 4 == 0 ) {
			if( year % 100 == 0 && year % 400 != 0 ) {
				result = false;
			} else {
				result = true;
      }
		} else {
			result = false;
		}
		return result;
	}

  public static void main ( String[] args) {
    int month = Integer.parseInt( args[0] );
    int day = Integer.parseInt( args[1] );
    int year = Integer.parseInt( args[2] );
    int daysAdded = Integer.parseInt( args[3] );
    System.out.println(WhatsTheDate(month, day, year, daysAdded ));
  }
}
