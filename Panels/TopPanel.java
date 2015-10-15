package connectfour.Panels;

import connectfour.Config.Board;
import connectfour.Config.Checker;
import connectfour.MainFrame;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * The TopPanel Class is top section of  the game board.
 * It contains buttons which are generated by MainFrame
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */
public class TopPanel extends JPanel {
  
  public TopPanel () {
    setPreferredSize(new java.awt.Dimension(Board.W * Checker.W, MainFrame.TOP_HEIGHT));
    setBackground(Color.WHITE);
    setBorder(BorderFactory.createLoweredBevelBorder());   
  }
}
