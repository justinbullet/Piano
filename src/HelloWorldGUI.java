import javax.swing.JFrame;
import quaters.*;
public class HelloWorldGUI {
    public static void main(String[] args) {
        // Create a new frame (window)
        JFrame frame = new JFrame("Hello World GUI");

        Q q = new Q();
        q.setSize(1600, 400);
        q.setPiano(9,23, 100);
        q.setVisible(true);
        // Set default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(q);
        // Set the frame siz
        frame.setSize(300, 100);
        frame.setVisible(true);
        // Make the frame visible

    }
}
