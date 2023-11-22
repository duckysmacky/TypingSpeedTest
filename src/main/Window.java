package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Window extends JFrame {
    private final App app;
    private final JFrame window;
    private Dimension size = new Dimension(1024, 1024);

    public Window(App app) {
        window = new JFrame();
        this.app = app;

        initWindow();
        calculateSize();
    }

    private void initWindow() {
        // Window
        setTitle("Typing Speed Test");
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

        // Window
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Header Panel
        JPanel header = new JPanel();
        header.setBounds((int)size.getWidth() / 4, 128, (int)size.getWidth() / 2, 128);
        header.setLayout(new GridLayout(1,2, 10, 10));
        header.setBackground(Color.LIGHT_GRAY);

        // Test label
        JLabel testLabel = new JLabel("Test Text");
        testLabel.setSize(100, 50);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        testLabel.setBorder(border);
        testLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add and render items
        header.add(testLabel);
        add(header);
        setVisible(true);
    }

    private void calculateSize() {
        while (true) {
            size = getBounds().getSize();
            System.out.println(size);
        }
    }
}
