
package connectfour.Sounds;
import java.applet.Applet;
import java.applet.AudioClip;
public class Sound {
  public static final AudioClip winner = 
    Applet.newAudioClip(Sound.class.getResource("winner.wav"));
    
  public static final AudioClip move = 
    Applet.newAudioClip(Sound.class.getResource("move.wav"));
}
