import org.jfugue.pattern.Pattern;

public class MusicGenerator {
    public Pattern createMusic(String note) {
        // Tạo một pattern với một nốt nhạc đơn
        return new Pattern(note);
    }
}
