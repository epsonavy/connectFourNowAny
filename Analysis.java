package connectfour;

/**
 * The Analysis Class is to analysis 2-dimension matrix data
 * 
 * @author      Pei Lian Liu
 * @version     1.0
 */
public class Analysis {
   /**
   * Return true if found the true table has (parameter: winLength) is true.
   * @param m[][] the true table of the player.
   * @param winLength the numbers of checkers connected in line to win
   * @return return true if won.
   */
  public static boolean isConnected(boolean m[][], int winLength) {
    int trueCounter = 0; // Counting true value
    
    // Check horizontal lines
    for (int i = 0; i < m.length; i++) { // row
      for (int j = 0; j <= m[0].length - winLength; j++) { // col
        for (int k = 0; k < winLength; k++) {
          if(m[i][j + k])
            trueCounter++;
          else
            trueCounter = 0;
        }
        if (trueCounter == winLength)
          return true; 
        else
          trueCounter = 0;
      }
    }
    
    // Check vertical lines
    for (int j = 0; j < m[0].length; j++) { // col
      for (int i = 0; i <= m.length - winLength; i++) { // row
        for (int k = 0; k < winLength; k++) {
          if(m[i + k][j])
            trueCounter++;
          else
            trueCounter = 0;
        }
        if (trueCounter == winLength)
          return true;
        else
          trueCounter = 0;
      }
    }
    
    // Check digonal lines from left bottom to right top
    for (int i = winLength - 1; i < m.length; i++) {
      for (int j = 0; j + winLength - 1 < m[0].length; j++) {
        for (int k = 0; k < winLength; k++) {
          if(m[i - k][j + k])
            trueCounter++;
          else
            trueCounter = 0;
        }
        if (trueCounter == winLength)
          return true;
        else
          trueCounter = 0;
      }
    }
    
    // Check digonal lines from right bottom left top
    for (int i = winLength - 1; i < m.length; i++) {
      for (int j = m[0].length - 1; j - winLength + 1 >= 0; j--) {
        for (int k = 0; k < winLength; k++) {
          if(m[i - k][j - k])
            trueCounter++;
          else
            trueCounter = 0;
        }
        if (trueCounter == winLength)
          return true;
        else
          trueCounter = 0;
      }
    }
    
    return false;
  }
  
}

/* Below was my old version to check CounterFour, only detect 4 checkers to win,
  And then I extend this algorithm to detect more than 4 checkers to win.

  public boolean isWin(boolean m[][]) {
    int winLength = 4;
    // Check horizontal lines
    for (int i = 0; i < m.length; i++) { // row
      for (int j = 0; j <= m[0].length - winLength; j++) { // col
        if(m[i][j] && m[i][j + 1] && m[i][j + 2] && m[i][j + 3]) 
          return true;  
      }
    }
    
    // Check vertical lines
    for (int j = 0; j < m[0].length; j++) { // col
      for (int i = 0; i <= m.length - winLength; i++) { // row
        if(m[i][j] && m[i + 1][j] && m[i + 2][j] && m[i + 3][j]) 
          return true;  
      }
    }
    
    // Check digonal lines from left bottom to right top
    for (int i = winLength - 1; i < m.length; i++) {
      for (int j = 0; j + 3 < m[0].length; j++) {
        if(m[i][j] && m[i - 1][j + 1] && m[i - 2][j + 2] && m[i - 3][j + 3])
          return true; 
      }
    }
    
    // Check digonal lines from right bottom left top
    for (int i = winLength - 1; i < m.length; i++) {
      for (int j = m[0].length - 1; j - 3 >= 0; j--) {
        if(m[i][j] && m[i - 1][j - 1] && m[i - 2][j - 2] && m[i - 3][j - 3])
          return true; 
      }
    }
    
    return false;
  }
  */