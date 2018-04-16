public class BigInteger {

  private boolean sign;
  private int[] num;
  private String value;
  public static final BigInteger ONE = new BigInteger("1");
  public static final BigInteger ZERO = new BigInteger("0");
  public static final BigInteger TEN = new BigInteger("10");

// one of several java.math.BigInteger constructors
  public BigInteger ( String val ){

    this.value = val.trim();    //Trims any whitespace

    this.sign = value.charAt(0) != '-';

    if(!this.sign) {     //Determins if the Big Integer is positive and assigns it to a boolean
      this.value = value.substring(1);
    }

    for(int i = 0; i < this.value.length(); i++ ) {   //Checks for leading zeros and whether the Big Integer is all zeros
      if(value.charAt(i) != '0') {
        value = value.substring(i);
        break;
      }
      if(i == this.value.length() - 1) {
        value = value.substring(i);
      }
    }

    num = new int[this.value.length()];
    for(int i = 0; i < num.length; i++) {
      num[i] = Integer.parseInt(value.substring(i, i+1));
    }
  }



// returns a BigInteger whose value is this plus val
  public BigInteger add ( BigInteger val ) {
    Boolean thisSignHolder = this.sign;
    Boolean valSignholder = val.sign;
    if(this.sign == false && val.sign == true) {
      this.sign = true;
      return val.subtract(this);
    } else if(val.sign == false && this.sign == true) {
      val.sign = true;
      return this.subtract(val);
    }

    int[] smallerArr;
    int[] biggerArr;
    if(this.num.length < val.num.length) {
      smallerArr = makeEqualLength(this.num, val.num);
      biggerArr = val.num;
    } else if(val.num.length < this.num.length) {
      smallerArr = makeEqualLength(val.num, this.num);
      biggerArr = this.num;
    } else {
      smallerArr = val.num;
      biggerArr = this.num;
    }

    int result[] = new int[biggerArr.length];
    int tempValue = 0;
    int carry = 0;
    for(int i = result.length - 1; i >= 0; i--) {
      tempValue = biggerArr[i] + smallerArr[i] + carry;
      if(tempValue < 10) {
        result[i] = tempValue;
        carry = 0;
      } else {
        if(i == 0) {
          result[i] = tempValue;
          break;
        }
        result[i] = tempValue - 10;
        carry = 1;
      }
    }

    BigInteger resultingBigInt = arrToBigInt(result);
    if(thisSignHolder == false && valSignholder == false) {
      resultingBigInt.sign = false;
    }
    return resultingBigInt;
  }



// returns a BigInteger whose value is this minus val
  public BigInteger subtract ( BigInteger val ) {
    if(this.sign == false && val.sign == true) {
      val.sign = false;
      return this.add(val);
    } else if(val.sign == false && this.sign == true) {
      val.sign = true;
      return val.add(this);
    }

    int[] smallerArr;
    int[] biggerArr;
    if(this.num.length < val.num.length) {
      smallerArr = makeEqualLength(this.num, val.num);
      biggerArr = val.num;
    } else if(val.num.length < this.num.length) {
      smallerArr = makeEqualLength(val.num, this.num);
      biggerArr = this.num;
    } else {
      if(this.absCompareTo(val) == 1) {
        biggerArr = this.num;
        smallerArr = val.num;
      } else if(this.absCompareTo(val) == -1) {
        biggerArr = val.num;
        smallerArr = this.num;
      } else {
        biggerArr = this.num;
        smallerArr = val.num;
      }
    }

    int[] result = new int[biggerArr.length];
    int tempValue = 0;
    int carry = 0;
    for(int i = result.length - 1; i >= 0; i--) {
      tempValue = (biggerArr[i] - carry) - smallerArr[i];
      if(tempValue < 0) {
        result[i] = 10 + tempValue;
        carry = 1;
      } else {
        result[i] = tempValue;
        carry = 0;
      }
    }
    BigInteger resultingBigInt = arrToBigInt(result);
    if(this.num.length < val.num.length) {
      if((val.sign == false && this.sign == false)) {
        resultingBigInt.sign = true;
      } else if(val.sign == true && this.sign == true) {
        resultingBigInt.sign = false;
      }
    } else if(val.num.length < this.num.length) {
      if(this.sign == true && val.sign == true) {
        resultingBigInt.sign = true;
      } else if(this.sign == false && val.sign == false) {
        resultingBigInt.sign = false;
      }
    } else {
      if(((this.sign == true && val.sign == true) && this.absCompareTo(val) == -1) ) {
        resultingBigInt.sign = false;
      } else if((this.sign == true && val.sign == true) && this.absCompareTo(val) == 1) {
        resultingBigInt.sign = true;
      } else if((this.sign == false && val.sign == false) && this.absCompareTo(val) == -1 || ((this.sign == false && val.sign == false) && this.absCompareTo(val) == 0)) {
        resultingBigInt.sign = true;
      } else {
        resultingBigInt.sign = false;
      }
    }
    return resultingBigInt;

  }

// returns a BigInteger whose value is this times val
  public BigInteger multiply ( BigInteger val ) {
    BigInteger result = new BigInteger("0");
    int[] smaller;
    int remainder = 0;
    Boolean condition = true;
    BigInteger bigger;
    Boolean thisSignHolder = this.sign;
    Boolean valSignholder = val.sign;


    if((this.absCompareTo(result) == 0) || (val.absCompareTo(result) == 0)) {
      result.sign = true;
      return result;
    } else if((this.absCompareTo(new BigInteger("1")) == 0) || (this.absCompareTo(new BigInteger("-1")) == 0)) {
      result = val;
      if((thisSignHolder == false && valSignholder == true) || (thisSignHolder == true && valSignholder == false)) {
        result.sign = false;
      } else {
        result.sign = true;
      }
      return result;
    } else if((val.absCompareTo(new BigInteger("1")) == 0) || (val.absCompareTo(new BigInteger("-1")) == 0)) {
      result = this;
      if((thisSignHolder == false && valSignholder == true) || (thisSignHolder == true && valSignholder == false)) {
        result.sign = false;
      } else {
        result.sign = true;
      }
      return result;
    }


    if(this.absCompareTo(val) == -1) {
      bigger = val;
      bigger.sign = true;
      smaller = this.num;
    } else {
      bigger = this;
      bigger.sign = true;
      smaller = val.num;
    }

    while(condition == true) {
      if((smaller[smaller.length - 1] % 2) != 0) {
        for(int i = 0; i < smaller.length; i++) {
          if(smaller[i] != 0) {
            if((i == (smaller.length - 1)) && (smaller[i] == 1)) {
              condition = false;
            }
            break;
          }
        }

        result = result.add(bigger);
        if(condition == false) {
          if((thisSignHolder == false && valSignholder == true) || (thisSignHolder == true && valSignholder == false)) {
            result.sign = false;
          } else {
            result.sign = true;
          }
          return result;
        }
        smaller[smaller.length - 1]--;
      }
      for(int i = 0; i < smaller.length; i++) {
        if((smaller[i] + remainder) == 1) {
          smaller[i] = 0;
          remainder = 10;
        } else if(((smaller[i] + remainder) % 2) != 0) {
          smaller[i] = (smaller[i] + remainder) / 2;
          remainder = 10;
        } else {
          smaller[i] = (smaller[i] + remainder) / 2;
          remainder = 0;
        }
      }
      bigger = bigger.add(bigger);
    }
    if((thisSignHolder == false && valSignholder == true) || (thisSignHolder == true && valSignholder == false)) {
      result.sign = false;
    } else {
      result.sign = true;
    }
    return result;
  }

// returns a BigInteger whose value is this divided by val
  public BigInteger divide ( BigInteger val ) {
    BigInteger remainder;
    BigInteger result = new BigInteger("0");
    Boolean thisSignHolder = this.sign;
    Boolean valSignholder = val.sign;
    BigInteger divided ;
    this.sign = true;
    val.sign = true;
    while(this.subtract(val).compareTo(new BigInteger("0")) == 1) {
      this = this.subtract(val);
      result = result.add(new BigInteger("1"));
    }
    remainder = this;
  }

  public BigInteger arrToBigInt(int[] arr) {
    String result = "";
    for(int i = 0; i < arr.length; i++) {
      result += arr[i];
    }
    return new BigInteger(result);
  }

  public int[] makeEqualLength(int[] arr1, int[] arr2) {
    int[] result = new int[arr2.length];
    int diff = arr2.length - arr1.length;
    for(int i = 0; i < diff; i++) {
      result[i] = 0;
    }
    for(int i = 0; i < arr1.length; i++) {
      result[i + diff] = arr1[i];
    }
    return result;
  }

  // returns the decimal string represention of this BigInteger
  public String toString () {
    if(!this.sign) {
      return "-" + this.value;
    } else {
      return this.value;
    }
  }

// returns -1 or 0 or 1 according to whether this BigInteger absolute value is less than equal to or greater than val
  public int absCompareTo ( BigInteger val ) {
    if(this.num.length > val.num.length) {
      return 1;
    } else if (val.num.length > this.num.length) {
      return -1;
    }
    for(int i = 0; i < this.num.length; i++) {
      if(this.num[i] > val.num[i]) {
        return 1;
      } else if(this.num[i] < val.num[i]) {
        return -1;
      }
    }
    return 0;
  }

// returns -1 or 0 or 1 according to whether this BigInteger value is less than equal to or greater than val
  public int compareTo ( BigInteger val ) {
    if(this.sign == false && val.sign == true) {
      return -1;
    } else if (val.sign == false && this.sign == true) {
      return 1;
    }
    if(this.num.length > val.num.length) {
      if(this.sign == false && val.sign == false) {
        return -1;
      }
      return 1;
    } else if (val.num.length > this.num.length) {
      if(this.sign == false && val.sign == false) {
        return 1;
      }
      return -1;
    }
    for(int i = 0; i < this.num.length; i++) {
      if(this.num[i] > val.num[i]) {
        if(this.sign == false && val.sign == false) {
          return -1;
        }
        return 1;
      } else if(this.num[i] < val.num[i]) {
        if(this.sign == false && val.sign == false) {
          return 1;
        }
        return -1;
      }
    }
    return 0;
  }

  public String arrToString (int[] arr) {
    String result = "";
    for(int i = 0; i < arr.length; i++) {
      result += arr[i];
    }
    return result;
  }

// returns true iff x is a BigInteger whose value is numerically equal to this BigInteger
  public boolean equals ( Object x ) {
  throw new UnsupportedOperationException();

  }


// constructs, and returns, a BigInteger from a long
  public static BigInteger valueOf ( long val ) {
  throw new UnsupportedOperationException();

  }


  public static void main (String[] args) {

    /*String addtest3 = args[0];
    String addtest4 = args[1];
    BigInteger addBigInt3 = new BigInteger(addtest3);
    BigInteger addBigInt4 = new BigInteger(addtest4);
    System.out.println(addBigInt3.add(addBigInt4).toString());

    String subtractTest3 = args[0];
    String subtractTest4 = args[1];
    BigInteger subtractBigInt3 = new BigInteger(subtractTest3);
    BigInteger subtractBigInt4 = new BigInteger(subtractTest4);
    System.out.println(subtractBigInt3.subtract(subtractBigInt4).toString());*/

    String test1 = args[0];
    String test2 = args[1];
    BigInteger tester1 = new BigInteger(test1);
    BigInteger tester2 = new BigInteger(test2);
    System.out.println(tester1.divide(tester2).toString());


  }
}
