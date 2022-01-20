import java.util.Scanner;

/**
 * Recursive bedtime story
 * @author Mr. Reid (adapted from http://programarcadegames.com/index.php?chapter=recursion&lang=en#section_19)
 * @course ICS4U
 * @date 2016/12/13
 */
public class RecursiveStory {
  
  static Scanner sc = null;
  
  /**
   * Recursive function
   */
  public static void sleepingStory(String what)
  {
    // Base case
    if (what.equals("weasel"))
    {
      System.out.println(" ... and weasel fell asleep");
    }
    else
    {
      System.out.print("A "+what+" couldn't sleep, so the "+what+"'s mother told them a story about a little: ");
      String nextAnimal = sc.nextLine();
      sleepingStory(nextAnimal);
      System.out.println(" ... and so the little "+what+" fell asleep;");
    }
  }
  
  /**
   * Main program
   */
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    sleepingStory("child");
  }
  
}
