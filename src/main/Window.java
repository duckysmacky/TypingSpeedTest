package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Window extends JFrame {
    private final App app;
    private final JFrame window;
    private final Dimension size = new Dimension(512, 512);

    public Window(App app) {
        window = new JFrame();
        this.app = app;

        setupWindow();
        setupItems();
    }

    private void setupWindow() {
        setTitle("Typing Speed Test");
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupItems() {
        JLabel testLabel = new JLabel("Text");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        testLabel.setBorder(border);
        testLabel.setSize(100, 50);

        add(testLabel, SwingConstants.CENTER);
        setVisible(true);
    }
}
