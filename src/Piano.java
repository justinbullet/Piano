

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Piano extends JFrame {
    public Piano() {
        setTitle("Piano");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Use null layout to easily change position

        JPanel pianoPanel = new JPanel();
        pianoPanel.setLayout(null);
        pianoPanel.setBounds(0, 0, 1920, 300); // Set position and location for PianoPanel
        add(pianoPanel);

        // Create KeyHandler object
        KeyHandler keyHandler = new KeyHandler();
        // Use KeyMapping to create keys
        KeyMapping.createKeys(pianoPanel, keyHandler);

        // Set the window in the middle of screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Piano::new);
    }
}
