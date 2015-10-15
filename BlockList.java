package connectfour;

import connectfour.Config.Board;
import java.util.ArrayList;

/**
 * The BlockList class is to accumulate all new adding Block Objects
 * Maintain the new Block Object only allow to add into available space
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */
public class BlockList {
  
  private ArrayList<Block> blocks = new ArrayList<>();
  private int availableSpace[] = new int[Board.W];
  
  //Create an object of BlockList (Singleton Pattern)
  private static final BlockList instance = new BlockList();
  
  //Make the constructor private so that this class cannot be
  //instantiated
  private BlockList(){}
  
  //Get the only object available
  public static BlockList getInstance(){
      return instance;
  }
  
  // Check BlockList is full or not
  public boolean isFull() {
    int sum = 0;
    for(int i = 0; i < availableSpace.length; i++)
      sum += availableSpace[i];
    return sum == 0;
  }
  
  
  public void reset() {
    // Clear blocks ArrayList
    blocks.clear();
    
    // Reset avaiable Space for all columns
    for (int i = 0;i < availableSpace.length;i++) { 
      availableSpace[i] = Board.H;
    }
    
  }
  
  // getter ////////////////////////////
  
  public ArrayList<Block> getBlocks() {
    return blocks;
  }
  
  public int getAvailableSpace(int col) {
    return availableSpace[col];
  }
  
  // setter ////////////////////////////
  
  public void decreaseSpace(int col) {
    availableSpace[col]--;
  }
  
}

