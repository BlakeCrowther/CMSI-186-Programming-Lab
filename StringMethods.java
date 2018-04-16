import java.util.Random;
public class StringMethods {

    /** Returns true iff s is the empty string. */
	public static boolean isEmptyString ( String s ) {
		return s.length() == 0;
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

public static String randomize( String s ) {
	String randomWord = "";
	char arr[] = s.toCharArray();
	int i = 0;
	while( i < arr.length ) {
		Random ran = new Random();
		int position = ran.nextInt( arr.length );
		randomWord += arr[position];
		i++;
	}
	return randomWord;
}


	public static boolean containsSubstring( String s, String t ) {
		boolean b = false;
		if( s.length() > t.length() ) {
			for( int i = 0; i < s.length(); i++ ) {
				if( s.charAt(i) == t.charAt(0) ) {
					for( int j = 0; j  < t.length(); j++ ) {
						if( s.charAt(i) == t.charAt(j)) {
							b = true;
							i++;
						} else {
							b = false;
							break;
						}
					}
				}
			}
		} else if ( t.length() > s.length() ) {
			for( int i = 0; i < t.length(); i++ ) {
				if( t.charAt(i) == s.charAt(0) ) {
					for( int j = 0; j  < s.length(); j++ ) {
						if( t.charAt(i) == s.charAt(j)) {
							b = true;
							i++;
						} else {
							b = false;
							break;
						}
					}
				}
			}
		}
		return b;
	}

	public static boolean areAnagrams( String s, String t ) {
		boolean result = false;
		if( (alphabeticalize(s)).equals(alphabeticalize(t)) ) {
			result = true;
		}
		return result;
	}

  public static boolean isLeap(int year) {
		boolean result = false;
		if( year % 4 == 0 ) {
			if( year % 100 == 0 && year % 400 != 0 ) {
				result = false;
			}
			else {
				result = true;
			}
		} else {
			result = false;
		}
		return result;
	}

	public static String everyOtherCharOf ( String s ) {
		String newWord = "";
		for ( int i = 1; i < s.length(); i+=2 ) {
			newWord += s.charAt(i);
		}
		return newWord;
	}

	public static String alphabeticalize ( String s ) {
		String sortedWord = "";
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'A' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'b' || s.charAt(i) == 'B' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'c' || s.charAt(i) == 'C' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'd' || s.charAt(i) == 'D' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'e' || s.charAt(i) == 'E' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'f' || s.charAt(i) == 'F' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'g' || s.charAt(i) == 'G' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'h' || s.charAt(i) == 'H' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'i' || s.charAt(i) == 'I' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'j' || s.charAt(i) == 'J' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'k' || s.charAt(i) == 'K' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'l' || s.charAt(i) == 'L' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'm' || s.charAt(i) == 'M' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'n' || s.charAt(i) == 'N' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'o' || s.charAt(i) == 'O' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'p' || s.charAt(i) == 'P' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'q' || s.charAt(i) == 'Q' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'r' || s.charAt(i) == 'R' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 's' || s.charAt(i) == 'S' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 't' || s.charAt(i) == 'T' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'u' || s.charAt(i) == 'U' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'v' || s.charAt(i) == 'V' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'w' || s.charAt(i) == 'W' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'x' || s.charAt(i) == 'X' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'y' || s.charAt(i) == 'Y' ) {
				sortedWord += s.charAt(i);
			}
		}
		for ( int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == 'z' || s.charAt(i) == 'Z' ) {
				sortedWord += s.charAt(i);
			}
		}
		return sortedWord;
	}

    /** Returns true iff s contains at least one instance of ch. */
	public static boolean containsChar ( String s, char ch ) {
		for ( int i = 0; i < s.length(); i++ ) {
			if ( s.charAt(i) == ch ) {
				return true;
			}
		}
		return false;
	}

    /** Returns true iff s contains at least one vowel. */
	public static boolean containsVowel ( String s) {
		return  containsChar(s,'A') || containsChar(s,'a') ||
                containsChar(s,'E') || containsChar(s,'e') ||
                containsChar(s,'I') || containsChar(s,'i') ||
                containsChar(s,'O') || containsChar(s,'o') ||
                containsChar(s,'U') || containsChar(s,'u');
	}

    /** Iterative method which returns true iff s is a palindrome. */
	public static boolean isPalindrome ( String s) {
		if ( s.length() <= 1 ) { return true; }
        else {
            int i, j;
            for ( i = 0, j = s.length()-1; i < j; i++, j-- ) {
                if ( s.charAt(i) != s.charAt(j) ) {
                    return false;
                }
            }

            return true;
        }
	}

    /** Recursive method which returns true iff s is a palindrome. */
	public static boolean isPalindrome2 ( String s) {
		if ( s.length() <= 1 ) {
            return true;
        }
        else if ( s.charAt(0) != s.charAt( s.length()-1 ) ) {
            return false;
        } else {
            switch ( s.length() ) {
                case 2 :
                case 3 :    return true;
                default :   return isPalindrome( s.substring ( 1, s.length()-1 ) );
            }
        }
	}

    /** Comprehensive set of tests for the above methods. */
    public static void main ( String[] args ) {

			  System.out.println ( "\nisLeap tests:" );
				System.out.println ( isLeap(2017) );

				System.out.println ( "\nisValid tests:" );
				System.out.println ( isValid(1, 31, 2016));
				System.out.println ( isValid(2, 29, 2016));
				System.out.println ( isValid(2, 29, 2017));
/*
        System.out.println ( "\nisEmptyString tests:" );
        System.out.println ( ! isEmptyString( "bcdef") );
        System.out.println ( ! isEmptyString( "3") );
        System.out.println ( isEmptyString( "") );
*/
			/*	System.out.println ("\neveryotherCharOf tests:" );
				System.out.println ( everyOtherCharOf( "hheelloo!!" ) );
				System.out.println ( everyOtherCharOf( "ddoogg" ) );
        System.out.println ( everyOtherCharOf( "ccaatt" ) );

				System.out.println ("\nalphabetize tests:" );
				System.out.println ( alphabeticalize( "DcBa" ));
				System.out.println ( alphabeticalize( "aPPles" ));
				System.out.println ( alphabeticalize( "Gin" ));

				System.out.println ("\ncontainsSubstring tests:");
				System.out.println (containsSubstring( "Horse", "or" ));
				System.out.println (containsSubstring( "Snoop Dogg", "og" ));
				System.out.println ( ! containsSubstring( "qrfqf", "banana" ));
				System.out.println (containsSubstring( "or", "horse" ));

				System.out.println ( "\ncontainsSubstring tests (8):" );
				System.out.println ( containsSubstring( "bcdef","cde") );
				System.out.println ( containsSubstring( "bcdef","def") );
				System.out.println ( containsSubstring( "bcdef","bc") );
				System.out.println ( containsSubstring( "bcdef","b") );
				System.out.println ( containsSubstring( "bcdef","f") );
				System.out.println ( ! containsSubstring( "bcdef","bcc") );
				System.out.println ( ! containsSubstring( "bcdef","cf") );

				System.out.println ( "\neveryOtherCharOf tests (7):" );
				System.out.println ( "yohn".equals (everyOtherCharOf( "Xylophone") ) );
				System.out.println ( "yohns".equals (everyOtherCharOf( "Xylophones") ) );
				System.out.println ( "b".equals (everyOtherCharOf( "ab") ) );
				System.out.println ( "b".equals (everyOtherCharOf( "aba") ) );
				System.out.println ( "bx".equals (everyOtherCharOf( "abax") ) );
				System.out.println ( "".equals (everyOtherCharOf( "a") ) );
				System.out.println ( "".equals (everyOtherCharOf( "") ) );

				System.out.println ( "\n alphabeticalize tests (5):" );
				System.out.println ( "ehlnoopsxy".equals (alphabeticalize( "xylophones") ) );
				System.out.println ( "ab".equals (alphabeticalize( "ba") ) );
				System.out.println ( "ab".equals (alphabeticalize( "ab") ) );
				System.out.println ( "a".equals (alphabeticalize( "a") ) );
				System.out.println ( "".equals (alphabeticalize( "") ) );

				System.out.println ("\n radomize tests:" );
				System.out.println ( randomize( "alphabet" ));
				System.out.println ( randomize( "GegwerT" ));
				System.out.println ( randomize( "radomness" ));

				System.out.println ("\n areAnagrams:");
				System.out.println ( areAnagrams( "tree", "reet" ));
				System.out.println ( areAnagrams( "beach", "cheab" ));
				System.out.println ( areAnagrams( "anagram", "nagaram"));

				System.out.println ( "\ncontainsSubstring tests (8):" );
        try { System.out.println ( StringMethods.containsSubstring( "bcdef","cde") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( StringMethods.containsSubstring( "bcdef","def") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( StringMethods.containsSubstring( "bcdef","bc") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( StringMethods.containsSubstring( "bcdef","b") ); } catch ( Exception e ) { System.out.println (false); }
      	try {  System.out.println ( StringMethods.containsSubstring( "bcdef","f") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( StringMethods.containsSubstring( "bcdef","") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( ! StringMethods.containsSubstring( "bcdef","bcc") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( ! StringMethods.containsSubstring( "bcdef","cf") ); } catch ( Exception e ) { System.out.println (false); }

        System.out.println ( "\neveryOtherCharOf tests (7):" );
        try { System.out.println ( "yohn".equals (StringMethods.everyOtherCharOf( "Xylophone") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "yohns".equals (StringMethods.everyOtherCharOf( "Xylophones") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "b".equals (StringMethods.everyOtherCharOf( "ab") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "b".equals (StringMethods.everyOtherCharOf( "aba") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "bx".equals (StringMethods.everyOtherCharOf( "abax") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "".equals (StringMethods.everyOtherCharOf( "a") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "".equals (StringMethods.everyOtherCharOf( "") ) ); } catch ( Exception e ) { System.out.println (false); }

        System.out.println ( "\nalphabeticalize tests (5):" );
        try { System.out.println ( "ehlnoopsxy".equals (StringMethods.alphabeticalize( "xylophones") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "ab".equals (StringMethods.alphabeticalize( "ba") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "ab".equals (StringMethods.alphabeticalize( "ab") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "a".equals (StringMethods.alphabeticalize( "a") ) ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( "".equals (StringMethods.alphabeticalize( "") ) ); } catch ( Exception e ) { System.out.println (false); }

        System.out.println ( "\nareAnagrams tests (7):" );
        try { System.out.println ( StringMethods.areAnagrams( "bcdef","cbdfe") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( StringMethods.areAnagrams( "bcdef","fedcb") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( StringMethods.areAnagrams( "","") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( StringMethods.areAnagrams( "a","a") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( ! StringMethods.areAnagrams( "abb","aba") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( ! StringMethods.areAnagrams( "aa","aaa") ); } catch ( Exception e ) { System.out.println (false); }
        try { System.out.println ( ! StringMethods.areAnagrams( "a","b") ); } catch ( Exception e ) { System.out.println (false); } */


    /*    System.out.println ( "\ncontainsVowel tests:" );
        System.out.println ( containsVowel("bcdaf") );
        System.out.println ( containsVowel("bcde") );
        System.out.println ( containsVowel("ibcd") );
        System.out.println ( containsVowel("iobcd") );
        System.out.println ( containsVowel("bucud") );
        System.out.println ( containsVowel("bcdAf") );
        System.out.println ( containsVowel("bcdE") );
        System.out.println ( containsVowel("Ibcd") );
        System.out.println ( containsVowel("IObcd") );
        System.out.println ( containsVowel("bUcUd") );
        System.out.println ( ! containsVowel("bcdFGh") );
        System.out.println ( ! containsVowel("") );

        System.out.println ( "\nisPalindrome tests:" );
        System.out.println ( isPalindrome("") );
        System.out.println ( isPalindrome("a") );
        System.out.println ( isPalindrome("bb") );
        System.out.println ( isPalindrome("bcb") );
        System.out.println ( isPalindrome("otto") );
        System.out.println ( isPalindrome("madamimadam") );
        System.out.println ( ! isPalindrome("bc") );
        System.out.println ( ! isPalindrome("bcc") );
        System.out.println ( ! isPalindrome("bcdb") );
        System.out.println ( ! isPalindrome("madaminadam") );

        System.out.println ( "\nisPalindrome2 tests:" );
        System.out.println ( isPalindrome2("") );
        System.out.println ( isPalindrome2("a") );
        System.out.println ( isPalindrome2("bb") );
        System.out.println ( isPalindrome2("bcb") );
        System.out.println ( isPalindrome2("otto") );
        System.out.println ( isPalindrome2("madamimadam") );
        System.out.println ( ! isPalindrome2("bc") );
        System.out.println ( ! isPalindrome2("bcc") );
        System.out.println ( ! isPalindrome2("bcdb") );
        System.out.println ( ! isPalindrome2("madaminadam") );		*/

    }
}
