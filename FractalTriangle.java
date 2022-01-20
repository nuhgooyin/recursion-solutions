import javax.swing.*;
import java.awt.*;

/**
 * Fractal Recursion Assignment
 * 
 * @author Dan Nguyen
 * @course ICS4U
 * @date 2022/01/07
 */
public class FractalTriangle extends JComponent {
  Graphics g = null;

  // Constructor
  public FractalTriangle() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit program when you close it
    frame.setSize(600, 400); // set the size of the window to whatever width and height you like
    frame.add(this); // put an object we can draw on in the centre of the window
    frame.setVisible(true); // show the window
  }

  /**
   * Draw triangles within itself in a certain pattern
   */
  public void drawTriangle(int x1, int y1, int size, Color c) {
    // Set colour
    this.g.setColor(c);

    // Calculate values and place into single arrays
    int[] xPoints = { x1, x1 + size, (size / 2) + x1 };
    int[] yPoints = { y1, y1, y1 - ((int) ((Math.sqrt(3) / 2) * size)) };

    // Pass on arrays and draw polygon
    this.g.drawPolygon(xPoints, yPoints, 3);

    // If base case stop calling and set colour
    if (size < 10) {
      this.g.setColor(Color.BLACK);
    }

    // Otherwise recursively call
    else {

      // Draw bottom left triangle (#1 in design)
      drawTriangle(x1, y1, size / 2, c.darker());

      // Draw top triangle (#2 in design)
      drawTriangle(x1 + size / 4, (int) (y1 - (Math.sqrt(3) / 2) * size / 2), size / 2, c.darker());

      // Draw bottom right triangle (#3 in design)
      drawTriangle(x1 + size / 2, y1, size / 2, c.darker());
    }
  }

  /**
   * Called whenever the screen is repainted
   */
  public void paint(Graphics g) {
    this.g = g;

    // Uncomment each of the functions here to see the patterns
    this.drawTriangle(100, 350, 400, Color.GREEN);
  }
}