

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

class KeyHandler implements ActionListener {
    private MusicPlayer musicPlayer;

    public KeyHandler() {
        musicPlayer = new MusicPlayer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String note = source.getText();
        System.out.println("Key pressed: " + note);

        Pattern pattern = createMusic(note);
        musicPlayer.playMusic(pattern);
    }

    public Pattern createMusic(String note) {
        return new Pattern("T120 " + note); // Adjust pattern as needed
    }

    public class MusicPlayer {
        private Player player;

        public MusicPlayer() {
            player = new Player();
        }

        public void playMusic(Pattern pattern) {
            new Thread(() -> player.play(pattern)).start();
        }
    }
}