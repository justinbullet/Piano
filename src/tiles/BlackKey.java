package tiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BlackKey extends JPanel {
    // Class implementation
    private final String bNote;
    boolean pedal = false;
    public BlackKey(int width, int height, String bNote, int bKey){
        this.bNote = bNote;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bindKey(bKey);
    }

    private void bindKey(int bKey){
        // Get input and action maps for key bindings
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        // Map the key press event to an action
        inputMap.put(KeyStroke.getKeyStroke(bKey, 0, false), "keyPressed");

        // Map the key release event to an action
        inputMap.put(KeyStroke.getKeyStroke(bKey, 0, true), "keyReleased");

        // Define the action for when the key is pressed
        actionMap.put("keyPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setBackground(Color.DARK_GRAY); // Change background to yellow on key press
                System.out.println("Key pressed: " + bNote);
            }
        });

        // Define the action for when the key is released
        actionMap.put("keyReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!pedal){
                setBackground(Color.BLACK); // Reset background to white on key release
                System.out.println("Key released: " + bNote);
                }
            }
        });
    }
}

