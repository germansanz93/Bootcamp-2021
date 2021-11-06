import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  /**
   * returns an arrayList made by the digits of the number that receives as an argument
   * but in reverse order. for example: if your input is 1234 this method returns [4, 3, 2, 1]
   * @param number a long number
   * @return ArrayList with the digits of number in reverese order
   * */
  public static ArrayList<Integer> numToArrayList(long number) {
    ArrayList<Integer> digitsArray = new ArrayList<>(); //ArrayList to save the digits
    long weight = 1;
    while (weight <= number){
      weight *= 10;
      digitsArray.add((int)((number%weight)/(weight/10))); //extracting all the digits from the number
    }
    return digitsArray;
  }

  /**
   * returns a boolean that indicates if the number received as an argument is palindrome
   * @param number a long to check if it is palindrome
   * @return isPalindrome  a boolean, true for palindrome, false for not palindrome
   * */
  public static boolean isPalindrome(long number){
    Integer[] digitsArray = numToArrayList(number).toArray(new Integer[0]); //call numToArray and parse to array
    boolean isPalindrome = true;
    int digitsQty = digitsArray.length;
    for(int i = 0; i < digitsQty / 2; i++){ //the for loop only loops through the indices of the first half
      isPalindrome = digitsArray[i] == digitsArray[digitsQty - 1 - i]; //compare the digits
      if(!isPalindrome) break; //if a comparison returns false break the loop with a false value.
    }

    return isPalindrome;
  }

  public static void main(String[] args) {

    //Scanner to capture the input
    Scanner input = new Scanner(System.in);

    // Handle input, input must be a positive Integer
    boolean isCorrectInputType = false;
    long number = 0L; //using long because i have no constraints. could use String instaed
    do{
      try{
        System.out.println("Insert an integer to check if it is a palindrome: ");
        number = input.nextLong();
        if(number < 10) throw new InputMismatchException(); //if number has only 1 digit or it is negative throw an exception
        isCorrectInputType = true; //if the execution reaches this line the input is correct
      } catch (InputMismatchException e){
        System.err.println("\nWrong input! Input only POSITIVE INTEGER NUMBERS with TWO DIGITS or more please...");
      }
      input.nextLine(); //clears the buffer
    }while(!isCorrectInputType);

    System.out.println(isPalindrome(number));
  }
}
