package listeners;

import main.App;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListener extends JTextField implements ActionListener {
    private App app;
    private final JTextField textField;

    public TextFieldListener(App app, JTextField textField) {
        this.app = app;
        this.textField = textField;

        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                registerText();
            }
            public void removeUpdate(DocumentEvent e) { registerText(); }
            public void insertUpdate(DocumentEvent e) { registerText(); }

            public void registerText() {
                String text = textField.getText();
                System.out.println(text);

                if (app.getState() == 0) {
//                    textField.setText("");
                    app.setState(1);
                } else if (app.getState() == 2) {
                    if (text != null && !text.isEmpty()) {
                        textField.setText(text.substring(0, text.length() - 1));
                    }
                }
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
