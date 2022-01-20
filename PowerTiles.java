import java.io.*;
import java.util.*;

/**
 * Power Tiles Recursion Assignment
 * 
 * @author Dan Nguyen
 * @course ICS4U
 * @date 2022/01/07
 */
public class PowerTiles {

  /**
   * Determine the minimum amount of tiles required to cover the floor
   * 
   * @param int n, int m
   * @return int result
   */
  private static int determineLeastRequired(int n, int m) {

    // Declare variable
    int result = 0;

    // Check for base case (total area is a square that is power of 2)
    if (Math.ceil((Math.log(n*m) / Math.log(2))) == (Math.floor((Math.log(n*m) / Math.log(2)))) && n == m) {
      result += 1;
    }

    else {
      // Make sure n is always smaller
      if (m < n) {
        int side;
        side = n;
        n = m;
        m = side;
      }

      // Determine the values for the power tile
      int lengthTile = (int) Math.pow(2, (int) (Math.log(n) / Math.log(2)));

      // Case #1: One rectangle must be divided
      if (lengthTile == n) {

        // Call recursion with cutout rectangle
        result = 1 + determineLeastRequired(n, m - lengthTile);
      }

      // Case #2: Two rectangles must be divided
      else {

        // Call recursion with cutout rectangles
        result = 1 + determineLeastRequired(n - lengthTile, m) + determineLeastRequired(lengthTile, m - lengthTile);
      }
    }

    return result;
  }

  /**
   * Main Program
   * 
   * @param args
   */
  public static void main(String[] args) throws Exception {
    // Connect Scanner to input file and output file
    Scanner sc = new Scanner(new FileReader("DATA3.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("OUT3.txt"));

    // Keep going until no more in data stream
    while (sc.hasNext()) {

      // Read line and parse
      String line = sc.nextLine();
      String[] twoVal = line.split(" ");

      // Record two needed input values
      int firstVal = Integer.parseInt(twoVal[0]);
      int secondVal = Integer.parseInt(twoVal[1]);

      // Pass inputs and perform recursion call
      int minReq = determineLeastRequired(firstVal, secondVal);

      // Output to file
      pw.println(minReq);
    }

    // Close and flush
    sc.close();
    pw.flush();
    pw.close();
  }
}