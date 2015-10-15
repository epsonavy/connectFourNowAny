package connectfour;

import connectfour.Config.Checker;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * The Block class is the visible Object of the checker
 * It extends JPanel and draw a fill Color circle to represent a checker
 * It has x,y coordinate location, the Color of the checker and 
 * the ownership of the checker.
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */

// Define a Block with specific Checker and color
public class Block extends JPanel {
 
  private int xCoord;
  private int yCoord;
  private Color checkerColor;
  private String ownership;
  
  public Block(int x,int y, Color color, String name) {
    JPanel panel = this;
    this.xCoord = x;
    this.yCoord = y;
    this.checkerColor = color;
    this.ownership = name;
    panel.setBounds(x * Checker.W, y * Checker.H, Checker.W, Checker.H);
  }
  
  @Override
  public void paint (Graphics g) {
    g.setColor(this.checkerColor);
    g.fillOval(0, 0, Checker.W, Checker.H);
  }

  public int getXCoord() {
    return xCoord;
  }
  
  public int getYCoord() {
    return yCoord;
  }
  
  public Color getColor() {
    return checkerColor;
  }
 
  public String getBelong() {
    return ownership;
  } 
}