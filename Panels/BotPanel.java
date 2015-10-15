package connectfour.Panels;

import connectfour.Config.Board;
import connectfour.Config.Checker;
import connectfour.MainFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The BotPanel Class is the bottom section of the game board.
 * It displays the information about which player's turn and 
 * who won and game over message.
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */
public class BotPanel extends JPanel {
  private final JLabel CurrentPlayer = new JLabel("Current Player: ");
  private final JLabel Using = new JLabel("Using Blue Checker");  
  
  public BotPanel () {
    setPreferredSize(new java.awt.Dimension(Board.W * Checker.W, MainFrame.BOTTOM_HEIGHT));
    setBackground(Color.ORANGE);
    setBorder(BorderFactory.createLoweredBevelBorder());
    add(CurrentPlayer);
    add(Using);
  }
  
  public void updateText(String text, Color color, int size) {
    Using.setText(text);
    Using.setForeground(color);
    Using.setFont(new Font("Serif", Font.PLAIN, size));
  }

}
