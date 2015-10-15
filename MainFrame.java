package connectfour;

import connectfour.Config.Checker;
import connectfour.Config.Board;
import connectfour.Panels.BotPanel;
import connectfour.Panels.TopPanel;
import connectfour.Panels.GamePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The MainFrame Class is the game board GUI and users interface
 * It has 3 JPanels (topPanel, gamePanel, botPanel)
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */

public class MainFrame extends JFrame implements ActionListener {
  public static final int TOP_HEIGHT = 40;
  public static final int BOTTOM_HEIGHT = 90;
  private final JButton[] B  = new JButton[20];
  private final JButton resetB = new JButton("Reset");
  private final TopPanel topPanel = new TopPanel(); 
  private GamePanel gamePanel = new GamePanel(); 
  private final BotPanel botPanel = new BotPanel(); 
   
  public MainFrame() {
    setTitle("Connect Four V1.0");
    // Plus extra 23 pixels are the height of the title bar
    setPreferredSize(new java.awt.Dimension(Board.W * Checker.W,
      Board.H * Checker.H + TOP_HEIGHT + BOTTOM_HEIGHT + 23));
    
    topPanel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    
    // Generating buttons according the column of the board
    for(int i = 1; i <= Board.W; i++) {
      B[i]  = new JButton("▼");
      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx = 0.5;
      c.gridx = i;
      c.gridy = 0;
      B[i].addActionListener(this);
      topPanel.add(B[i], c);
    }
    
    resetB.addActionListener(this);
    botPanel.add(resetB);
    
    add(topPanel, BorderLayout.NORTH);
    add(gamePanel, BorderLayout.CENTER);
    add(botPanel, BorderLayout.SOUTH);
    setLocation(50,20);
    setResizable(false);
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    gamePanel.resetBoard();
    botPanel.updateText("Using Blue Checker", Color.BLUE, 24);
  }
  
  // Whenever clicking buttons, update Panels (OBSERVER Pattern)
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == resetB) {
      gamePanel.resetBoard();
      botPanel.updateText("Using Blue Checker", Color.BLUE, 24);
    }
    
    for(int i = 0; i < Board.W; i++) {
      if (e.getSource() == topPanel.getComponent(i)) {
        gamePanel.place(i);
        updateInfo();
      }
    }
  }
  
  // Update readible information
  public void updateInfo() {
    if (gamePanel.getGameOverStatus()) {
      botPanel.updateText("GAME OVER! Click Reset to Replay!", Color.BLACK, 32);
    } else {
      if (gamePanel.getWonStatus()) {
        if(gamePanel.getWhoTurn())
          botPanel.updateText("Player1 WON!", Color.BLUE, 32);
        else 
          botPanel.updateText("Player2 WON!", Color.RED, 32);
      } else {
        if (gamePanel.getWhoTurn())
          botPanel.updateText("Using Black Checker", Color.BLUE, 24);
        else
          botPanel.updateText("Using White Checker", Color.RED, 24);
      }
    }
  }
}