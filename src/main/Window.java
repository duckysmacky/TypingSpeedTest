package main;

import javax.swing.*;
import java.awt.*;

public class Window {
    private final App app;
    private final JFrame window;
    private Dimension size = new Dimension(1024, 1024);

    private final Font heading1 = new Font("Helvetica", Font.BOLD, 48);
    private final Font heading2 = new Font("Helvetica", Font.PLAIN, 36);
    private final Font subHeading1 = new Font("Helvetica", Font.BOLD, 28);
    private final Font subHeading2 = new Font("Helvetica", Font.PLAIN, 22);

    private final Color backgroundColor = Color.decode("#05161A");
    private final Color foregroundColor1 = Color.decode("#072E33");
    private final Color accentColor1 = Color.decode("#0C7075");
    private final Color accentColor2 = Color.decode("#0F968C");
    private final Color mainColor = Color.decode("#6DA5C0");
    private final Color additionalColor = Color.decode("#294D61");

    public Window(App app) {
        window = new JFrame();
        this.app = app;

        initWindow();
    }

    private void initWindow() {
        int w = (int)size.getWidth();
        int h = (int)size.getHeight();

        // Window Size
        window.setMinimumSize(size);
        window.setPreferredSize(size);
        window.setMaximumSize(size);

        // Window Style
        window.setTitle("Typing Speed Test");
        window.getContentPane().setBackground(backgroundColor);
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);
//        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));

        // Title Panel
        JPanel head = new JPanel(new BorderLayout());
        head.setBounds(w / 8, h / 32, w / 2 + w / 4, h / 16 + h / 16);
        head.setBorder(BorderFactory.createEmptyBorder(16,16,16,16)); // Border Offset
        head.setBackground(foregroundColor1);

        // Title label
        JLabel heading = new JLabel("Simple Typing Speed Test", SwingConstants.CENTER);
        heading.setFont(heading1);
        heading.setForeground(mainColor);

        // Title label
        JLabel subHeading = new JLabel("This simple app allows you to test your typing speed. Made by Ducky", SwingConstants.CENTER);
        subHeading.setFont(subHeading2);
        subHeading.setForeground(accentColor2);

        // Body Panel
        JPanel body = new JPanel(new BorderLayout());
        head.setBounds(w / 8, h / 32, w / 2 + w / 4, h / 16 + h / 16);
        head.setBorder(BorderFactory.createEmptyBorder(32,32,32,32));
        head.setBackground(foregroundColor1);

        // TextBox Panel
        JPanel textBox = new JPanel(new BorderLayout());
        head.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
        textBox.setBackground(foregroundColor1);

        // Add to panels
        head.add(heading, BorderLayout.CENTER);
        head.add(subHeading, BorderLayout.SOUTH);

        textBox.add(new JLabel("Text text text"), BorderLayout.NORTH);
        body.add(textBox, BorderLayout.SOUTH);

        // Add to window
        window.add(head, BorderLayout.NORTH);
        window.add(body, BorderLayout.SOUTH);
        window.setVisible(true);
    }

    private void calculateSize() {
        while (true) {
            size = window.getBounds().getSize();
        }
    }
}
