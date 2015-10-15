package connectfour;

import javax.swing.SwingUtilities;


/**
 * This is the Main.
 * 
 * @author Pei Lian Liu
 */
public class Main {
  
  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater( ()->new PreStart() );
  }
  
}
