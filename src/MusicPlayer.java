import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

public class MusicPlayer {
    private Player player;

    public MusicPlayer() {
        player = new Player();
    }

    public void playMusic(Pattern pattern) {
        // Phát bản nhạc từ Pattern
        player.play(pattern);
    }
}
 