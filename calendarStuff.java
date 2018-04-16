public class CalendarStuff {

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

  public static boolean inOrder( int month1, int day1, int year1, int month2, int day2, int year2 ) {
    boolean result = false;
    if( isValid( month1, day1, year1 ) == false || isValid( month2, day2, year2 ) == false ) {
      result = false;
    } else {
      if(year1 < year2){
        result = true;
      } else if(year1 == year2) {
        if(month1 < month2) {
          result = true;
        } else if(month1 == month2) {
          if(day1 < day2) {
            result = true;
          } else if (day1 == day2) {
            result = true;
          }
        }
      }
    }
    return result;
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

  public static void main ( String [] args ) {
      test_isLeap();  // 8 tests
      test_isValid(); // 27 tests
      test_inOrder(); // 10 tests
  }

  static void test_isLeap(){

      System.out.println ( "\nEIGHT TESTS FOR isLeap():\n" );

      try { System.out.println ( CalendarStuff.isLeap (1600) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isLeap (1700) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isLeap (1800) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isLeap (1900) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isLeap (1992) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isLeap (1993) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isLeap (1994) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isLeap (1995) ); }
      catch ( Exception e ) { System.out.println ( false ); }
  }

  static void test_isValid() {

      System.out.println ( "\nTWENTY-SEVEN TESTS FOR isValid():\n" );

      try { System.out.println ( ! CalendarStuff.isValid (0,10,2000) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (13,25,2001) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (11,0,2000) ); }
      catch ( Exception e ) { System.out.println ( false ); }


      try { System.out.println ( CalendarStuff.isValid (1,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (1,32,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (2,28,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (2,29,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (3,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (3,32,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (4,30,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (4,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (5,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (5,32,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (6,30,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (6,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (7,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (7,32,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (8,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (8,32,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (9,30,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (9,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (10,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (10,32,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (11,30,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (11,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.isValid (12,31,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.isValid (12,32,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

  }

  static void test_inOrder() {

      System.out.println ( "\nTEN TESTS FOR inOrder():\n" );

      try { System.out.println ( ! CalendarStuff.inOrder (1,32,2000,2,1,2000) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.inOrder (1,1,2000,2,29,2001) ); }
      catch ( Exception e ) { System.out.println ( false ); }


      try { System.out.println ( ! CalendarStuff.inOrder (12,31,2014,12,20,2014) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.inOrder (11,30,2014,12,31,2013) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.inOrder (10,15,2005,10,10,2005) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( ! CalendarStuff.inOrder (10,15,2005,9,20,2005) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.inOrder (9,1,2005,9,1,2005) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.inOrder (2,10,2005,8,12,2005) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.inOrder (9,1,2005,8,2,2006) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      try { System.out.println ( CalendarStuff.inOrder (9,10,2005,7,8,2007) ); }
      catch ( Exception e ) { System.out.println ( false ); }

      System.out.println(daysInMonth(2, 2016));
  }
}
