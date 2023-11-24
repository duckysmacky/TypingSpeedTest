package main;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListener extends JTextField implements ActionListener {
    private final JTextField textField;

    TextFieldListener(JTextField textField) {
        this.textField = textField;

        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                registerText();
            }
            public void removeUpdate(DocumentEvent e) {
                registerText();
            }
            public void insertUpdate(DocumentEvent e) {
                registerText();
            }

            public void registerText() {

                System.out.println(textField.getText());

            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        String text = textField.getText();
        System.out.println("Text entered: " + text);
        if (text.equals("test")) {
            System.out.println("tested");
        }
    }
}
