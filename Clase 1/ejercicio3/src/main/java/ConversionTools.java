public class ConversionTools {

  /**
   * method that parse a number from decimal to binary.
   * it takes a long as input because i have no constraints about the input
   * @param decimal a decimal long nmumber
   * @return binary a binary version of decimal
   * this method runs once and then it calls
   * @see #decimalToBinary(long, String, boolean)
   * */
  public static String decimalToBinary(long decimal){
    boolean isPositive = true;
    //if decimal is between -1 and 1 returns it
    if(Math.abs(decimal) <= 1){
      return Long.toString(decimal);
    }
    //if decimal is less than to -1 set isPositive flag to negative and continue with the absolute value of decimal
    if(decimal < -1) {
      decimal = Math.abs(decimal);
      isPositive = false;
    };
    long quotient = decimal / 2;
    String binary = Long.toString(decimal % 2);
    //recursive call, but at this point we are calling the private version
    return decimalToBinary(quotient, binary, isPositive);
  }

  /**
   * After the first call to #decimalToBinary(long) this method is called
   * recursively to get the binary version of decimal
   * @see #decimalToBinary(long)
   * */
  private static String decimalToBinary(long decimal, String binary, boolean isPositive){
    //base case. If the flag isPositive is setted to false add the sign
    if(decimal == 1) return isPositive ? "1" + binary : "-1" + binary;
    long quotient = decimal / 2;
    binary = Long.toString(decimal % 2) + binary;
    //recursive call
    return decimalToBinary(quotient, binary, isPositive);
  }

  /**
   * This method does the same as
   * @see #decimalToBinary(double)
   * but receiving a double as argument and colling
   * @see #decimalToBinary(double) for the integer part and
   * @see #fractionDecimalToBinary(double) for the fraction part
   *
   * @param decimal a decimal double number
   * */
  public static String decimalToBinary(double decimal){
    boolean isPositive = true;
    //if decimal is less than zero sets isPositive flag to false nad use the abs value of decimal
    if(decimal < 0) {
      decimal = Math.abs(decimal);
      isPositive = false;
    }

    //takes only the integer part of decimal
    Long integerPart = ((long) decimal);

    //takes only the fraction part of decimal
    double fractionPart = decimal - integerPart;

    //with the integer part calls #decimalToBinary(long)
    String binaryIntegerPart = decimalToBinary(integerPart);

    //with the fraction part calls #fractionDecimalToBinary(double)
    String binaryFractionPart = fractionDecimalToBinary(fractionPart);

    //returns the concat of binaryIntegerPart and binaryFractionPart
    String fullNumber = isPositive ? binaryIntegerPart + "." + binaryFractionPart : "-" + binaryIntegerPart + "." + binaryFractionPart;
    return fullNumber;
  }

  /**
   * takes only the fraction part of a decimal number and
   * returns its binary equivalent;
   * this method is called by
   * @see #decimalToBinary(double)
   * and this version only runs once, then it calls to
   * @see #fractionDecimalToBinary(double, String)
   * */
  private static String fractionDecimalToBinary( double fractionDecimalPart){
    if(fractionDecimalPart == 0) return "0";
    String fractionBinaryPart = "";
    fractionDecimalPart *= 2;
    //if the fraction part is greather than or equal 1 puts a 1 in the binary, else puts a 0
    if(fractionDecimalPart >= 1){
      fractionDecimalPart -= 1;
      fractionBinaryPart += "1";
    }else {
      fractionBinaryPart += "0";
    }
    //recursive call
    return fractionDecimalToBinary(fractionDecimalPart, fractionBinaryPart);
  }

  /**
   * After the first call to #fractionDecimalToBinary(double) this method is called
   * recursively to get the binary version of decimal fraction part of the number
   * @see #fractionDecimalToBinary(double) 
   * */
  private static String fractionDecimalToBinary( double fractionDecimalPart, String fractionBinaryPart){
    //if fractionDecimalPart == 0, we have absolute precision, if not, the precision is limited by 15 recursive calls
    if(fractionDecimalPart == 0 || fractionBinaryPart.length() >= 15) return fractionBinaryPart;
    fractionDecimalPart = fractionDecimalPart * 2;
    if(fractionDecimalPart >= 1){
      fractionDecimalPart -= 1;
      fractionBinaryPart += "1";
    }else {
      fractionBinaryPart += "0";
    }
    return fractionDecimalToBinary(fractionDecimalPart, fractionBinaryPart);
  }
}
