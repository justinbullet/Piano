package quaters;
import java.awt.event.KeyEvent;
import javax.swing.*;
import tiles.*;

public class Q extends JLayeredPane {

    public Q() {
        setLayout(null); // Set layout to null for absolute positioning
    }

    public void setPiano(int start, int finish, int keyWidth) {
        int whiteKeyPosition = 0;
        int blackKeyOffset = keyWidth / 3; // Offset to align black keys between white keys

        // Add white keys first to the base layer
        for (int i = start; i <= finish; i++) {
            if (!isBlackKey(i)) { // White key
                WhiteKey whiteKey = new WhiteKey(keyWidth, this.getHeight(), String.valueOf(i), KeyEvent.VK_SPACE);
                whiteKey.setBounds(whiteKeyPosition, 0, keyWidth, this.getHeight());
                this.add(whiteKey, JLayeredPane.DEFAULT_LAYER); // Add white keys to the default layer
                whiteKeyPosition += keyWidth; // Move position for the next white key
            }
        }

        // Add black keys afterward to the higher layer
        whiteKeyPosition = 0; // Reset position for black key placement
        for (int i = start; i <= finish; i++) {
            if (isBlackKey(i)) { // Black key
                BlackKey blackKey = new BlackKey(keyWidth / 3 * 2, this.getHeight() / 3 * 2, String.valueOf(i), KeyEvent.VK_ENTER);
                int blackKeyPosition = whiteKeyPosition - blackKeyOffset;
                blackKey.setBounds(blackKeyPosition, 0, blackKey.getWidth(), blackKey.getHeight());
                this.add(blackKey, JLayeredPane.PALETTE_LAYER); // Add black keys to a higher layer
            } else {
                whiteKeyPosition += keyWidth; // Move to next white key position
            }
        }

        // Repaint the panel to update the display
        revalidate();
        repaint();
    }

    // Helper function to check if the key is black
    private boolean isBlackKey(int keyNumber) {
        int mod = keyNumber % 12;
        return mod == 1 || mod == 3 || mod == 6 || mod == 8 || mod == 10;
    }
    private boolean isDeleted(int i){
        int mod = i % 12;
        return mod == 1 || mod == 3 ||mod  == 5|| mod == 6 || mod == 8 || mod == 10 || mod  == 12;
    }
}
