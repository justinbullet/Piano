package tiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class WhiteKey extends JPanel {
    private final String note;
    boolean pedal = false;
    public WhiteKey(int width, int height, String note, int keyCode) {
        this.note = note;
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Bind the key press and key release events
        bindKey(keyCode);
    }

    private void bindKey(int keyCode) {
        // Get input and action maps for key bindings
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        // Map the key press event to an action
        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, false), "keyPressed");

        // Map the key release event to an action
        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, true), "keyReleased");

        // Define the action for when the key is pressed
        actionMap.put("keyPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setBackground(Color.LIGHT_GRAY); // Change background to gray on key press
                System.out.println("Key pressed: " + note);
            }
        });

        // Define the action for when the key is released
        actionMap.put("keyReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!pedal){
                setBackground(Color.WHITE); // Reset background to white on key release
                System.out.println("Key released: " + note);
                }
            }
        });
    }
        //getter/setter
        public boolean pedalON(){
            return pedal;
        }
        public boolean pedalOFF(){
            return !pedal;
        }
        public String getNote(){
            return note;
        }
}


