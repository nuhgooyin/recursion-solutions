import javax.swing.*;
import java.awt.*;

/**
 * Source: https://trina.si/2017/06/20/drawing-a-koch-snowflake-in-java/
 * Check fractalTriangle for custom design and implementation.
 */
public class FractalSnowflake extends JComponent
{
	Graphics g = null;

	// Constructor
	public FractalSnowflake()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // exit program when you close it
		frame.setSize(600,400);  // set the size of the window to whatever width and height you like
		frame.add(this); // put an object we can draw on in the centre of the window
		frame.setVisible(true); //show the window
	}

	/**
	 * Draw koch snowflake fractal
	 */
	public void drawSnowflake (int x1, int y1, int x5, int y5, int depth)
	{
    // Declare variables
    int diffX, diffY, x2, y2, x3, y3, x4, y4;

    // Check if depth of recursion has been reached (base case)
    if (depth == 0) {
      this.g.drawLine(x1, y1, x5, y5);
    }

    // Else calculate coordinates and continue recursion
    else {
      
      // Calculating Delta values for x and y using inputted values
      diffX = x5 - x1;
      diffY = y5 - y1;

      // Calculate second x and y coordinates using Delta
      x2 = x1 + diffX / 3;
      y2 = y1 + diffY / 3;
      
      // Calculate third x and y using other coordinates
      x3 = (int) (0.5 * (x1 + x5) + Math.sqrt(3) * (y1 - y5) / 6);
      y3 = (int) (0.5 * (y1 + y5) + Math.sqrt(3) * (x5 - x1) / 6);

      // Calculate fourth x and y 
      x4 = x1 + 2 * diffX / 3;
      y4 = y1 + 2 * diffY / 3;

      // Recursively call 
      drawSnowflake (x1, y1, x2, y2, depth - 1);
      drawSnowflake (x2, y2, x3, y3, depth - 1);
      drawSnowflake (x3, y3, x4, y4, depth - 1);
      drawSnowflake (x4, y4, x5, y5, depth - 1);
    }
	}

	/**
	 * Called whenever the screen is repainted
	 */
	public void paint(Graphics g)
	{
		this.g = g;

		// Draw each side of the original triangle
    this.drawSnowflake(160,280,420,280,5);
    this.drawSnowflake(420,280,290,20,5);
    this.drawSnowflake(290,20,160,280,5);
	}
}