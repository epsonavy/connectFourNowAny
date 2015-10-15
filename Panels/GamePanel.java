
package connectfour.Panels;

import connectfour.Analysis;
import connectfour.Block;
import connectfour.BlockList;
import connectfour.Config.Board;
import connectfour.Config.Checker;
import connectfour.Config.Connected;
import connectfour.Player;
import connectfour.Sounds.Sound;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * The GamePanel Class is the main of the game board.
 * It displays player's checkers in certain location by clicking button 
 * from TopPanel.
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */
public class GamePanel extends JPanel {
  private final BlockList blockList = BlockList.getInstance(); // Singleton
  private final Player player1 = new Player("Player1", Color.BLUE);
  private final Player player2 = new Player("Player2", Color.RED);
  // playerSwitch = true indicates current player: Player1 (Blue)
  // playerSwitch = false indicates current player: Player2 (Red)
  private boolean playerSwitch = true;
  private boolean isWon = false;
  private boolean isGameOver = false;
  
  public GamePanel() {
    setSize(new java.awt.Dimension(Board.W * Checker.W, Board.H * Checker.H));
    setBackground(Color.GRAY);
    setBorder(BorderFactory.createLoweredBevelBorder());
    setLayout(null);
  }
  
  // Get who is playing 
  public boolean getWhoTurn() {
    return playerSwitch;
  }
  
  // Get win or not status
  public boolean getWonStatus() {
    return isWon;
  }
  
  // Get is this game over?
  public boolean getGameOverStatus() {
    return isGameOver;
  }
  
  // Reset the game
  public void resetBoard() {
    isWon = false;
    isGameOver = false;
    for (Block block : blockList.getBlocks()) remove(block);
    blockList.reset();
    player1.resetTrueTable();
    player2.resetTrueTable();
    repaint();
  }
  
  // Repaint the game board 
  public void updateBoard() {
    for (Block block : blockList.getBlocks()) add(block);
    repaint();
  }
  
  /**
   * Adding a checker(Block Object) to BlockList.
   * @param column the column of the board.
   * @param player the ownership of the checker.
   */
  private void addChecker(int column, Player player) {
    if (blockList.getAvailableSpace(column) > 0) {
      blockList.getBlocks().add(new Block(
        column, 
        blockList.getAvailableSpace(column) - 1, 
        player.getColor(), 
        player.getName()
        ));
      blockList.decreaseSpace(column);
      
      updateBoard();
    }
  }
  
  /**
   * Placing the checker in the board
   * @param column the column of the board.
   */
  public void place(int column) {
    if (blockList.getAvailableSpace(column) > 0 && !isWon) {
      Sound.move.play();
      if (playerSwitch) {
        addChecker(column, player1);
        player1.setTrueTable(column, blockList.getAvailableSpace(column), true);
        playerSwitch = false;
      } else {
        addChecker(column, player2);
        player2.setTrueTable(column, blockList.getAvailableSpace(column), true);
        playerSwitch = true;
      }
      
      if(Analysis.isConnected(player1.getTrueTable(), Connected.Length)) {
        setWonState();
        playerSwitch = true;
      }
      
      if(Analysis.isConnected(player2.getTrueTable(), Connected.Length)) {
        setWonState();
        playerSwitch = false;
      }
      
      if(!isWon && blockList.isFull()) {
        isGameOver = true;
      }
    }
  }
  
  // Set win condition true and play won sound
  public void setWonState() {
    isWon = true;
    Sound.winner.play();
  }
}
