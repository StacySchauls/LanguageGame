/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stacy
 */
import java.awt.*;
import javax.swing.*;

public class WsuWindow extends JFrame 
{
   /**
    * The zero-parameter constructor for WsuWindow.
    * This creates a component at location (25, 25) (the
    * upper-left corner of the container), of size 300 x 400.
    */
   public WsuWindow() {
      this(25, 25, 400, 300);
   }
   
   /**
    * The four-parameter constructor for WsuWindow.
    * This creates a window at the given location and
    * of the given size. 
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the content pane.
    * @param h The height of the content pane.
    */
   public WsuWindow(int x, int y, int w, int h) {
      setSize(w, h);
      setLocation(x, y);
      setVisible(true);
      getContentPane().setLayout(null);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
   
   /**
    * Add the given component to the content pane of this window.
    * This method will make the component appear "on top" of any 
    * components already added to the current window. This method 
    * returns a reference to the newly added component.
    * 
    * @param c The component to be added.
    * @return  The newly added component.
    */
   public Component add(Component c) {
      getContentPane().add(c, 0);
      return c;
   }
   
   /**
    * Set the size of the component.
    * @param w The desired width.
    * @param h The desired height.
    */
   public void setSize(int w, int h) { 
      super.setSize(w, h); 
   }
   /**
    * Get the width of the component.
    * @return The current height of the component.
    */
   public int getWidth() { 
      return super.getWidth(); 
   }
   /**
    * Get the height of the component.
    * @return The current width of the component.
    */
   public int getHeight() { 
      return super.getHeight(); 
   }
   /**
    * Set the size of the component.
    * @param d The desired dimensions.
    */
   public void setSize(Dimension d) { 
      super.setSize(d); 
   }
   /**
    * Get the size of the component.
    * @return The current size of the component.
    */
   public Dimension getSize() { 
      return super.getSize(); 
   }
   
   /**
    * Set the location of the component.
    * @param x The x-coordinate for the component, upper-left corner.
    * @param y The y-coordinate for the component, upper-left corner.
    */
   public void setLocation(int x, int y) { 
      super.setLocation(x, y); 
   }
   /**
    * Get the x-coordinate of the component (upper-left corner).
    * @return The x-coordinate of the component.
    */
   public int getX() { 
      return super.getX(); 
   }
   /**
    * Get the y-coordinate of the component (upper-left corner).
    * @return The y-coordinate of the component.
    */
   public int getY() { 
      return super.getY(); 
   }
   /**
    * Set the location of the component.
    * @param p The desired location, upper-left corner.
    */
   public void setLocation(Point p) {
      super.setLocation(p); 
   }
   /**
    * Get the location of the component.
    * @return The current location of the upper-left corner of the component.
    */
   public Point getLocation() { 
      return super.getLocation(); 
   }
   
   /**
    * Get the content pane (central working area) of the window.
    * @return The content pane.
    */
   public Container getContentPane() { 
      return super.getContentPane(); 
   }
   
   /**
    * Set the title for the window.
    * @param s The desired title for the window.
    */
   public void setTitle(String s) { 
      super.setTitle(s); 
   }
   /**
    * Get the title of the window.
    * @return The current title of the window.
    */
   public String getTitle() { 
      return super.getTitle(); 
   }
   
   /**
    * Request that the window be brought to the front of the stack
    * of windows.
    */
   public void toFront() { 
      super.toFront();
   }
   
   /**
    * Request that the window render (repaint) itself.
    */
   public void repaint() { 
      super.repaint(); 
   }
   
}

/**
 * WsuComponent is the basis for the shapes in 
 * WsuLibrary. It is a simple container/component
 * based on the java.awt.Container class.
 */
class WsuComponent extends Container {

   private boolean filled = false;
   
   /**
    * The zero-parameter constructor for WsuComponent.
    * This creates a component at location (0, 0) (the
    * upper-left corner of the container), of size 25 x 25.
    * The component is not filled, with a line color
    * (foreground) of black, and a fill color (background)
    * of white.
    */
   public WsuComponent() {
      this(0, 0, 25, 25);
   }
   
   /**
    * The four-parameter constructor for WsuComponent.
    * This creates a component at the given location and
    * of the given size. The component is not filled, with 
    * a line color (foreground) of black, and a fill 
    * color (background) of white.
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the component.
    * @param h The height of the component.
    */
   public WsuComponent(int x, int y, int w, int h) {
      setBounds(x, y, w, h);
      setForeground(Color.black);
      setBackground(Color.white);
      setLayout(null);
   }
   
   /**
    * Add the given component to this container. This method
    * will make the component appear "on top" of any components
    * already added to the current container. This method returns
    * a reference to the newly added component.
    * 
    * @param c The component to be added.
    * @return  The newly added component.
    */
   public Component add(Component c) {
      add(c, 0);
      return c;
   }
   
   /**
    * Set the filled status of the component.
    * 
    * @param b The new value for the filled property.
    */
   public void setFilled(boolean b) {
      filled = b;
   }
   /**
    * Get the filled status of the component.
    * 
    * @return  The value of the filled property.
    */
   public boolean isFilled() {
      return filled;
   }
   
   /** 
    * Set the background (fill) color for the component.
    * @param c The desired background color.
    */
   public void setBackground(Color c) { 
      super.setBackground(c); 
   }
   /**
    * Get the background (fill) color for the component.
    * @return The current background color.
    */
   public Color getBackground() { 
      return super.getBackground(); 
   }
   /** 
    * Set the foreground (line) color for the component.
    * @param c The desired foreground color.
    */
   public void setForeground(Color c) { 
      super.setForeground(c); 
   }
   /**
    * Get the foreground (line) color for the component.
    * @return The current foreground color.
    */
   public Color getForeground() { 
      return super.getForeground(); 
   }
   
   /**
    * Set the size of the component.
    * @param w The desired width.
    * @param h The desired height.
    */
   public void setSize(int w, int h) { 
      super.setSize(w, h); 
   }
   /**
    * Get the width of the component.
    * @return The current height of the component.
    */
   public int getWidth() { 
      return super.getWidth(); 
   }
   /**
    * Get the height of the component.
    * @return The current width of the component.
    */
   public int getHeight() { 
      return super.getHeight(); 
   }
   /**
    * Set the size of the component.
    * @param d The desired dimensions.
    */
   public void setSize(Dimension d) { 
      super.setSize(d); 
   }
   /**
    * Get the size of the component.
    * @return The current size of the component.
    */
   public Dimension getSize() { 
      return super.getSize(); 
   }
   
   /**
    * Set the location of the component.
    * @param x The x-coordinate for the component, upper-left corner.
    * @param y The y-coordinate for the component, upper-left corner.
    */
   public void setLocation(int x, int y) { 
      super.setLocation(x, y); 
   }
   /**
    * Get the x-coordinate of the component (upper-left corner).
    * @return The x-coordinate of the component.
    */
   public int getX() { 
      return super.getX(); 
   }
   /**
    * Get the y-coordinate of the component (upper-left corner).
    * @return The y-coordinate of the component.
    */
   public int getY() { 
      return super.getY(); 
   }
   /**
    * Set the location of the component.
    * @param p The desired location, upper-left corner.
    */
   public void setLocation(Point p) { 
      super.setLocation(p); 
   }
   /**
    * Get the location of the component.
    * @return The current location of the upper-left corner of the component.
    */
   public Point getLocation() { 
      return super.getLocation(); 
   }
   
   /**
    * Request that the component render (repaint) itself.
    */
   public void repaint() { 
      super.repaint(); 
   }
   
}

/**
 * WsuRectangle is the simplest graphic component 
 * in WsuLibrary. It is described by the coordinates
 * of the upper-left corner (x, y) and its size
 * (width, height).
 * <blockquote><img src="images/rectangle.png" alt="rectangle" ></blockquote>
 */
class WsuRectangle extends WsuComponent {
   
   /**
    * The zero-parameter constructor for WsuRectangle.
    * This creates a component at location (0, 0) (the
    * upper-left corner of the container), of size 25 x 25.
    * The component is not filled, with a line color
    * (foreground) of black, and a fill color (background)
    * of white.
    */
   public WsuRectangle() {
      super(0, 0, 25, 25);
   }
   
   /**
    * The four-parameter constructor for WsuRectangle.
    * This creates a component at the given location and
    * of the given size. The component is not filled, with 
    * a line color (foreground) of black, and a fill 
    * color (background) of white.
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the component.
    * @param h The height of the component.
    */
   public WsuRectangle(int x, int y, int w, int h) {
      super(x, y, w, h);
   }
   
   /**
    * Rendering instructions for the object
    * 
    * @param g The Graphics object to update the display.
    */
   public void paint(Graphics g) {
      if(isFilled())
      {
         g.setColor(getBackground());
         g.fillRect(0, 0, getWidth(), getHeight());
      }
      g.setColor(getForeground());
      g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
      super.paint(g);
   }
}

/**
 * WsuEllipse is one of the simple graphic
 * components in WsuLibrary. It presents an ellipse
 * inscribed within a bounding rectangle. The bounds 
 * of the component describe the bounding rectangle.
 * That is, by the coordinates
 * of the upper-left corner (x, y) and its size
 * (width, height).
 * <blockquote><img src="images/ellipse.png" alt="ellipse"></blockquote>
 */
class WsuEllipse extends WsuComponent {
   
   /**
    * The zero-parameter constructor for WsuEllipse.
    * This creates a component at location (0, 0) (the
    * upper-left corner of the container), of size 25 x 25.
    * The component is not filled, with a line color
    * (foreground) of black, and a fill color (background)
    * of white.
    */
   public WsuEllipse() {
      super(0, 0, 25, 25);
   }
   
   /**
    * The four-parameter constructor for WsuEllipse.
    * This creates a component at the given location and
    * of the given size. The component is not filled, with 
    * a line color (foreground) of black, and a fill 
    * color (background) of white.
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the component.
    * @param h The height of the component.
    */
   public WsuEllipse(int x, int y, int w, int h) {
      super(x, y, w, h);
   }
   
   /**
    * Rendering instructions for the object
    * 
    * @param g The Graphics object to update the display.
    */
   public void paint(Graphics g) {
      if(isFilled())
      {
         g.setColor(getBackground());
         g.fillOval(0, 0, getWidth(), getHeight());
      }
      g.setColor(getForeground());
      g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
      super.paint(g);
   }
}

/**
 * WsuDiamond is one of the simple graphic
 * components in WsuLibrary. It presents a rhombus
 * inscribed within a bounding rectangle. The bounds 
 * of the component describe the bounding rectangle.
 * The rhombus intersects the midpoints of each side
 * of the bounding rectangle.
 * <blockquote><img src="images/diamond.png" alt="diamond"></blockquote>
 */
class WsuDiamond extends WsuComponent {
   
   /**
    * The zero-parameter constructor for WsuDiamond.
    * This creates a component at location (0, 0) (the
    * upper-left corner of the container), of size 25 x 25.
    * The component is not filled, with a line color
    * (foreground) of black, and a fill color (background)
    * of white.
    */
   public WsuDiamond() {
      super(0, 0, 25, 25);
   }
   
   /**
    * The four-parameter constructor for WsuDiamond.
    * This creates a component at the given location and
    * of the given size. The component is not filled, with 
    * a line color (foreground) of black, and a fill 
    * color (background) of white.
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the component.
    * @param h The height of the component.
    */
   public WsuDiamond(int x, int y, int w, int h) {
      super(x, y, w, h);
   }
   
   /**
    * Rendering instructions for the object
    * 
    * @param g The Graphics object to update the display.
    */
   public void paint(Graphics g) {
      int h = getHeight();
      int w = getWidth();
      int h2 = getHeight() / 2;
      int w2 = getWidth() / 2;
      if(isFilled())
      {
         g.setColor(getBackground());
         g.fillPolygon(new int[] {0, w2, w, w2},
                       new int[] {h2, 0, h2, h}, 
                       4);
      }
      g.setColor(getForeground());
      g.drawPolygon(new int[] {0, w2, w - 1, w2},
                    new int[] {h2, 0, h2, h - 1}, 
                    4);
      super.paint(g);
   }
}

/**
 * WsuUpTriangle is one of the simple graphic
 * components in WsuLibrary. It presents a triangle
 * inscribed within a bounding rectangle. The bounds 
 * of the component describe the bounding rectangle.
 * One side of this isosceles triangle is the bottom 
 * of the bounding rectangle.
 * <blockquote><img src="images/uptriangle.png" alt="upward triangle"></blockquote>
 */
class WsuUpTriangle extends WsuComponent {
   
   /**
    * The zero-parameter constructor for WsuUpTriangle.
    * This creates a component at location (0, 0) (the
    * upper-left corner of the container), of size 25 x 25.
    * The component is not filled, with a line color
    * (foreground) of black, and a fill color (background)
    * of white.
    */
   public WsuUpTriangle() {
      super(0, 0, 25, 25);
   }
   
   /**
    * The four-parameter constructor for WsuUpTriangle.
    * This creates a component at the given location and
    * of the given size. The component is not filled, with 
    * a line color (foreground) of black, and a fill 
    * color (background) of white.
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the component.
    * @param h The height of the component.
    */
   public WsuUpTriangle(int x, int y, int w, int h) {
      super(x, y, w, h);
   }
   
   /**
    * Rendering instructions for the object
    * 
    * @param g The Graphics object to update the display.
    */
   public void paint(Graphics g) {
      int h = getHeight();
      int w = getWidth();
      int h2 = getHeight() / 2;
      int w2 = getWidth() / 2;
      if(isFilled())
      {
         g.setColor(getBackground());
         g.fillPolygon(new int[] {0, w, w2},
                       new int[] {h, h, 0},
                       3);
      }
      g.setColor(getForeground());
      g.drawPolygon(new int[] {0, w - 1, w2},
                    new int[] {h - 1, h - 1, 0},
                    3);
      super.paint(g);
   }
}

/**
 * WsuDownTriangle is one of the simple graphic
 * components in WsuLibrary. It presents a triangle
 * inscribed within a bounding rectangle. The bounds 
 * of the component describe the bounding rectangle.
 * One side of this isosceles triangle is the top 
 * of the bounding rectangle.
 * <blockquote><img src="images/downtriangle.png" alt="downward triangle"></blockquote>
 */
class WsuDownTriangle extends WsuComponent {
   
   /**
    * The zero-parameter constructor for WsuDownTriangle.
    * This creates a component at location (0, 0) (the
    * upper-left corner of the container), of size 25 x 25.
    * The component is not filled, with a line color
    * (foreground) of black, and a fill color (background)
    * of white.
    */
   public WsuDownTriangle() {
      super(0, 0, 25, 25);
   }
   
   /**
    * The four-parameter constructor for WsuDownTriangle.
    * This creates a component at the given location and
    * of the given size. The component is not filled, with 
    * a line color (foreground) of black, and a fill 
    * color (background) of white.
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the component.
    * @param h The height of the component.
    */
   public WsuDownTriangle(int x, int y, int w, int h) {
      super(x, y, w, h);
   }
   
   /**
    * Rendering instructions for the object
    * 
    * @param g The Graphics object to update the display.
    */
   public void paint(Graphics g) {
      int h = getHeight();
      int w = getWidth();
      int h2 = getHeight() / 2;
      int w2 = getWidth() / 2;
      if(isFilled())
      {
         g.setColor(getBackground());
         g.fillPolygon(new int[] {0, w, w2},
                       new int[] {0, 0, h},
                       3);
      }
      g.setColor(getForeground());
      g.drawPolygon(new int[] {0, w - 1, w2},
                    new int[] {0, 0, h - 1},
                    3);
      super.paint(g);
   }
}

/**
 * WsuLeftTriangle is one of the simple graphic
 * components in WsuLibrary. It presents a triangle
 * inscribed within a bounding rectangle. The bounds 
 * of the component describe the bounding rectangle.
 * One side of this isosceles triangle is the right side 
 * of the bounding rectangle.
 * <blockquote><img src="images/lefttriangle.png" alt="leftward triangle"></blockquote>
 */
class WsuLeftTriangle extends WsuComponent {
   
   /**
    * The zero-parameter constructor for WsuLeftTriangle.
    * This creates a component at location (0, 0) (the
    * upper-left corner of the container), of size 25 x 25.
    * The component is not filled, with a line color
    * (foreground) of black, and a fill color (background)
    * of white.
    */
   public WsuLeftTriangle() {
      super(0, 0, 25, 25);
   }
   
   /**
    * The four-parameter constructor for WsuLeftTriangle.
    * This creates a component at the given location and
    * of the given size. The component is not filled, with 
    * a line color (foreground) of black, and a fill 
    * color (background) of white.
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the component.
    * @param h The height of the component.
    */
   public WsuLeftTriangle(int x, int y, int w, int h) {
      super(x, y, w, h);
   }
   
   /**
    * Rendering instructions for the object
    * 
    * @param g The Graphics object to update the display.
    */
   public void paint(Graphics g) {
      int h = getHeight();
      int w = getWidth();
      int h2 = getHeight() / 2;
      int w2 = getWidth() / 2;
      if(isFilled())
      {
         g.setColor(getBackground());
         g.fillPolygon(new int[] {0, w, w},
                       new int[] {h2, h, 0},
                       3);
      }
      g.setColor(getForeground());
      g.drawPolygon(new int[] {0, w - 1, w - 1},
                    new int[] {h2, h - 1, 0},
                    3);
      super.paint(g);
   }
}

/**
 * WsuRightTriangle is one of the simple graphic
 * components in WsuLibrary. It presents a triangle
 * inscribed within a bounding rectangle. The bounds 
 * of the component describe the bounding rectangle.
 * One side of this isosceles triangle is the left side 
 * of the bounding rectangle.
 * <blockquote><img src="images/righttriangle.png" alt="rightward triangle"></blockquote>
 */
class WsuRightTriangle extends WsuComponent {
   
   /**
    * The zero-parameter constructor for WsuRightTriangle.
    * This creates a component at location (0, 0) (the
    * upper-left corner of the container), of size 25 x 25.
    * The component is not filled, with a line color
    * (foreground) of black, and a fill color (background)
    * of white.
    */
   public WsuRightTriangle() {
      super(0, 0, 25, 25);
   }
   
   /**
    * The four-parameter constructor for WsuRightTriangle.
    * This creates a component at the given location and
    * of the given size. The component is not filled, with 
    * a line color (foreground) of black, and a fill 
    * color (background) of white.
    * 
    * @param x The x-coordinate for the component.
    * @param y The y-coordinate for the component.
    * @param w The width of the component.
    * @param h The height of the component.
    */
   public WsuRightTriangle(int x, int y, int w, int h) {
      super(x, y, w, h);
   }
   
   /**
    * Rendering instructions for the object
    * 
    * @param g The Graphics object to update the display.
    */
   public void paint(Graphics g) {
      int h = getHeight();
      int w = getWidth();
      int h2 = getHeight() / 2;
      int w2 = getWidth() / 2;
      if(isFilled())
      {
         g.setColor(getBackground());
         g.fillPolygon(new int[] {0, 0, w},
                       new int[] {h, 0, h2},
                       3);
      }
      g.setColor(getForeground());
      g.drawPolygon(new int[] {0, 0, w - 1},
                    new int[] {h - 1, 0, h2},
                    3);
      super.paint(g);
   }
}

/**
 * WsuLine is one of the simple graphic components 
 * in WsuLibrary. It presents a line. The endpoints
 * of the line describe a bounding rectangle for this
 * component. The endpoints giving opposite corners of
 * this bounding rectangle. Setting the size of this 
 * component therefore adjusts one or both endpoints of
 * the line.
 * <blockquote><img src="images/line.png" alt="line"></blockquote>
 */
class WsuLine extends Component {
   
   private boolean nw_se;
   
   /**
    * The four-parameter constructor for WsuLine.
    * This creates a component with the given endpoints. 
    * The line color (foreground) is black.
    * 
    * @param x1 The x-coordinate for the first endpoint.
    * @param y1 The y-coordinate for the first endpoint.
    * @param x2 The x-coordinate for the first endpoint.
    * @param y2 The y-coordinate for the first endpoint.
    */
   public WsuLine(int x1, int y1, int x2, int y2) {
      setEndPoints(x1, y1, x2, y2);
      setForeground(Color.black);
   }
   
   /**
    * Sets the endpoints for the current WsuLine.
    * 
    * @param x1 The x-coordinate for the first endpoint.
    * @param y1 The y-coordinate for the first endpoint.
    * @param x2 The x-coordinate for the first endpoint.
    * @param y2 The y-coordinate for the first endpoint.
    */
   public void setEndPoints(int x1, int y1, int x2, int y2) {
      if(x1 > x2) {
         int temp = x1;
         x1 = x2;
         x2 = temp;
         temp = y1;
         y1 = y2;
         y2 = temp;
      }
      if(x1 == x2)
         x2 ++;
      if(y1 > y2) {
         int temp = y1;
         y1 = y2;
         y2 = temp;
         nw_se = false;
      } else {
         nw_se = true;
      }
      if(y1 == y2)
         y2 ++;
      setSize(x2 - x1, y2 - y1);
      setLocation(x1, y1);
   }
   
   /**
    * Rendering instructions for the object
    * 
    * @param g The Graphics object to update the display.
    */
   public void paint(Graphics g) {
      g.setColor(getForeground());
      if(nw_se)
         g.drawLine(0, 0, getWidth() - 1, getHeight() - 1);
      else
         g.drawLine(0, getHeight() - 1, getWidth() - 1, 0);
   } 
}

