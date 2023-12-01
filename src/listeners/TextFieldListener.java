package listeners;

import main.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextFieldListener extends JTextField implements ActionListener {
    private final App app;
    private final JTextField textField;
    private String ghostText;
    private String newText;
    private String oldText = "";

    public TextFieldListener(App app, JTextField textField, String ghostText) {
        this.app = app;
        this.textField = textField;
        this.ghostText = ghostText;

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // do nothing
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // do nothing
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (app.getState() == 0) {
                    textField.setText("");
                    app.setState(1);
                } else if (app.getState() == 1) {
                    newText = textField.getText().replace(oldText, "");
                    textField.setText(oldText + newText);
                    oldText = textField.getText();
                    System.out.println("Old: " + oldText + "\nNew: " + newText);
                    checkText();
                }
            }

        });
    }

    public void checkText() {
        int maxLength = ghostText.length();
        int currentLength = textField.getDocument().getLength();
        String checkText = ghostText.substring(0, currentLength);

        System.out.println("To check: " + checkText);

        if (textField.getText().equals(checkText)) {
            System.out.println("We good");
        } else {
            System.out.println("Found errors!");
        }

        System.out.println("\n-----\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
