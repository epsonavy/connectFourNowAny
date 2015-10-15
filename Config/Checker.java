package connectfour.Config;

/**
 *
 * @author Pei Lian Liu
 */

// Define the pixels of one Checker according to the size of Board class
public class Checker {
  public static int BOARD_PIXEL = 540;
  public static int max = Math.max(Board.H, Board.W);
  public static int H = BOARD_PIXEL / max; 
  public static int W = BOARD_PIXEL / max; 
}
