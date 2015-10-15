package connectfour;

import connectfour.Config.Board;
import java.awt.Color;

/**
 * The Player Class is some basic info for the Player.
 * It also records player placed checker location by
 * using 2 dimensions boolean array.
 * Each player has their own true/false table
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */

public class Player {
  private String name = "";
  private final Color checkerColor;
  private boolean[][] trueTable = new boolean[Board.W][Board.H];
  
  public Player (String name, Color color) {
    this.name = name;
    this.checkerColor = color;
    resetTrueTable();
  }
  
  // getter ////////////////////////
  
  public String getName() {
    return this.name;
  }
  
  public Color getColor() {
    return this.checkerColor;
  }
  
  public boolean[][] getTrueTable() {
    return trueTable;
  }
  
  // setter ////////////////////////
  
  public void setTrueTable(int x, int y, boolean bool) {
    trueTable[x][y] = bool;
  }
  
  public void resetTrueTable() {
    for (int i = 0;i < Board.W;i++) {
      for (int j = 0;j < Board.H;j++) {
        trueTable[i][j] = false;
      }
    }
  }
}
