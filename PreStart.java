package connectfour;

import connectfour.Config.Board;
import connectfour.Config.Connected;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * The PreStart class is a simple GUI and let user to change
 * the setting of the game board size, and the winning condition.
 * The default of the game board size is 6 X 6,
 * The maximum size is 19 X 19.
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */
public class PreStart extends JFrame implements ActionListener, MouseListener {
  private final JLabel Welcome = new JLabel("Welcome to ConnectFour!");
  private final JLabel P1 = new JLabel("Player1:");
  private final JPanel Check1 = new JPanel();
  private final JLabel P2 = new JLabel("Player2:");
  private final JPanel Check2 = new JPanel();;
  private final JLabel Height = new JLabel("Height:");
  private final JLabel Wide = new JLabel("X  Wide:");
  private final Choice ChoiceH = new Choice();
  private final Choice ChoiceW = new Choice();
  private final JButton Play = new JButton("Let's Play");
  private final JLabel winLength = new JLabel("Winning condtion: Length = ");
  private final Choice ChoiceLen = new Choice();
  
  private final JTextArea Content = new JTextArea();

  // Draw two checkers just for displaying, better than nothing on GUI
  private class Draw2Checkers extends JPanel{
      @Override
      public void paintComponent(Graphics g){
      g.setColor(Color.BLUE);
      g.fillOval(105, 57, 60, 60);
      g.setColor(Color.RED);
      g.fillOval(290, 57, 60, 60);
      }
  }
  
  public PreStart() {

    setTitle("Connect Four V1.0 Setting");
    setPreferredSize(new java.awt.Dimension(450, 550));
    
    Welcome.setFont(new Font("Serif", Font.BOLD, 32));
    setContentPane(new Draw2Checkers());
    for (int i = 4; i < 20; i++) {
      ChoiceH.add(Integer.toString(i));
      ChoiceW.add(Integer.toString(i));
    }   
    ChoiceH.select("6");
    ChoiceW.select("6");
    for (int i = 3; i < 11; i++) {
      ChoiceLen.add(Integer.toString(i));
    }   
    ChoiceLen.select("4");
    
    Content.append("Above are some simple setting for this game,\n"
      + "You may change game board size and win condition,\n"
      + "The maximum size is 19 X 19.\n"
      + "Click \"Let's play\" button to start.\n\n"
      + "How to play:\n"
      + "1) Decide who players first. Players will alternate turns after\n"
      + "    playing a checker.\n"
      + "2) Player1 uses Blue Checker and Player2 uses Red Checker.\n"
      + "3) When the game started, you'll see some \"▼\" buttons on the\n"
      + "    top. Click \"▼\" button to drop the Checker in that slot.\n"
      + "4) If you're the first player to get four of your checkers\n"
      + "    in a row, you win the game.\n\n"
      + "Have fun ^_^ !!!\n"
      + "                                   @Author Pei Lian Liu");
    Content.setEditable(false);
    
    Play.addActionListener(this);
    ChoiceLen.addMouseListener(this);
    
    // Use GridBagLayout (Layout Manager Pattern)
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    // First row
    c.weightx = 0;
    c.weighty = 1;
    c.gridwidth = 5;
    c.gridx = 0;
    c.gridy = 0;
    add(Welcome, c);
    
    // Second row
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 1;
    add(P1, c);
    
    c.gridx = 3;
    c.gridy = 1;
    add(P2, c);
    
    // Third row
    c.gridx = 0;
    c.gridy = 2;
    add(Height, c);

    c.gridx = 1;
    c.gridy = 2;
    add(ChoiceH, c);

    c.gridx = 2;
    c.gridy = 2;
    add(Wide, c);

    c.gridx = 3;
    c.gridy = 2;
    add(ChoiceW, c);
    
    c.gridx = 4;
    c.gridy = 2;
    add(Play, c);
    
    // Fourth row
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 3;
    add(winLength, c);
    
    c.gridwidth = 1;
    c.gridx = 3;
    c.gridy = 3;
    add(ChoiceLen, c);
    
    // Fifth row
    c.gridwidth = 5;
    c.gridx = 0;
    c.gridy = 4;
    add(Content, c);
    
    pack();
    setLocation(50,20);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  // Update Configuration
  private void updateConfig() {
    Board.H = Integer.parseInt(ChoiceH.getSelectedItem());
    Board.W = Integer.parseInt(ChoiceW.getSelectedItem());
    Connected.Length = Integer.parseInt(ChoiceLen.getSelectedItem());
  }

  // Open MainFrame and dispose this JFrame.
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == Play) {
      updateConfig();
      SwingUtilities.invokeLater( ()->new MainFrame());
      this.dispose();
    }
  }
  
  // Just change the Welcome Label for fun
  @Override
  public void mouseClicked(MouseEvent e) {
    Welcome.setForeground(Color.RED);
    Welcome.setText("Welcome to ConnectANY!!");
    repaint();
    ChoiceLen.removeMouseListener(this);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // Do Nothing
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // Do Nothing
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // Do Nothing
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // Do Nothing
  }
  
}
