

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

class KeyMapping {
    public static void createKeys(JPanel panel, KeyHandler keyHandler) {
        int whiteKeyWidth = 60;
        int whiteKeyHeight = 300;
        int blackKeyWidth = 40;
        int blackKeyHeight = 180;
        int keyOffset = 0;

        // Create white keys
        for (int i = 0; i < 21; i++) {
            JButton whiteKey = new JButton();
            whiteKey.setBounds(keyOffset, 0, whiteKeyWidth, whiteKeyHeight);
            whiteKey.setBackground(Color.WHITE);
            whiteKey.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            whiteKey.setText("C" + (i % 7 + 1)); // Example note labels
            whiteKey.addActionListener(keyHandler);
            panel.add(whiteKey);
            keyOffset += whiteKeyWidth;
            // Create black keys
            if (i % 7 != 2 && i % 7 != 6) { // Skip positions for black keys
                JButton blackKey = new JButton();
                blackKey.setBounds(keyOffset - blackKeyWidth / 2, 0, blackKeyWidth, blackKeyHeight);
                blackKey.setBackground(Color.BLACK);
                blackKey.setForeground(Color.BLACK);
                blackKey.setBorder(BorderFactory.createEmptyBorder());
                blackKey.setText(""); // No text for black keys
                blackKey.addActionListener(keyHandler);
                panel.add(blackKey);
            }
        }

        // Update UI
        panel.revalidate();
        panel.repaint();
    }
}