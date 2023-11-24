package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener extends JButton implements ActionListener {
    private JButton startButton;

    public StartButtonListener(JButton startButton) {
        this.startButton = startButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
