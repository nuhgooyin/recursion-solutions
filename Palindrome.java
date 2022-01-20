import java.util.Scanner;

/**
 * Palindrome Recursion Assignment
 * 
 * @author Dan Nguyen
 * @course ICS4U
 * @date 2022/01/07
 */
public class Palindrome {

  /**
   * Determine whether the word is a palindrome or not
   * 
   * @param String word
   * @return boolean result
   */
  private static boolean determinePalindrome(String word) {

    // Declare variable
    boolean result = false;

    // If it reaches the base case then yes it is a palindrome
    if (word.length() == 0 || word.length() == 1) {
      result = true;
    }

    // Else if the first and last char of the string are equal
    else if (word.charAt(0) == (word.charAt(word.length() - 1))) {

      // Call it recursively but remove the first and last char
      result = determinePalindrome(word.substring(1, word.length() - 1));
    }
    return result;
  }

  /**
   * Main Program
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Ask user for word to determine if palindrome
    Scanner sc = new Scanner(System.in);
    System.out.println("Determine if the following is a palindrome: ");
    String userInput = sc.nextLine();

    // Determine if palindrome recursively
    boolean answer = determinePalindrome(userInput);

    // Results
    if (answer == false) {
      System.out.println(userInput + " is not a palindrome.");
    } else {
      System.out.println(userInput + " is a palindrome.");
    }

    sc.close();
  }
}