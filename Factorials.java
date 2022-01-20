import java.util.Scanner;

/**
 * Factorial examples
 * 
 * @author Mr. Reid
 * @course ICS4UC
 * @date 2020/05/24
 */
public class Factorials {

	/**
	 * Calculate the factorial of a number
	 * with a loop
	 * @param n
	 * @return
	 */
	private static int factorialIter(int n) {
		int result = 1;
		// Every digit to n
		for (int i=1; i<=n; i++) {
			// Include that digit in the product
			result = result * i;
		}
		return result;
	}

	/**
	 * Calculate the factorial recursively
	 * @param n
	 * @return
	 */
	private static long factorialRecur(long n) {
		long result = 1;
		// If it's not the base case
		if (n > 1) {
			// Call it recursively
			result = n * factorialRecur(n-1);
		}
		return result;
	}	
	
	/**
	 * Main Program
	 * @param args
	 */
	public static void main(String[] args) {
		// Ask user for value of n to calculate n! (factorial of n)
		Scanner sc = new Scanner(System.in);
		System.out.print("Value to get factorial of? (n!): ");
		int n = sc.nextInt();
		
		// Factorial iteratively
		//int answer = factorialIter(n);
		
		// Factorial recursively
		long answer = factorialRecur(n);

		// Results
		System.out.println("The factorial of "+n+" is "+answer);
		
	}
}

	