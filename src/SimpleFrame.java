import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import tiles.*;

public class SimpleFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Swing Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.setSize(400, 300);

            WhiteKey C = new WhiteKey(50, 150, "C6", KeyEvent.VK_SPACE);
            BlackKey D = new BlackKey(50, 150, "D6", KeyEvent.VK_ENTER);

            frame.add(C);
            frame.add(D);

            frame.setVisible(true);
        });
    }
}
