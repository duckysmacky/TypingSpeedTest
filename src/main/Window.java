package main;

import listeners.TextFieldListener;

import javax.swing.*;
import java.awt.*;

public class Window {
    private final App app;
    private final JFrame window;
    private Dimension size = new Dimension(1024, 1024);

    private JLabel wpm;
    private JLabel timePassed;
    private JTextField textField;

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

    private String ghostText = "This is a test sentence. You have to write it.";

    public Window(App app) {
        window = new JFrame();
        this.app = app;

        initWindow();
        renderStats();
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
        window.setLayout(null);
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
        JLabel subHeading = new JLabel("This simple app allows you to test your typing speed", SwingConstants.CENTER);
        subHeading.setFont(subHeading2);
        subHeading.setForeground(accentColor2);



        // Body Panel
        JPanel body = new JPanel(new BorderLayout());
        body.setBounds(w / 8, h / 32 + h / 6, w / 2 + w / 4, h / 2 + h / 8);
        body.setBorder(BorderFactory.createEmptyBorder(32,32,32,32));
        body.setBackground(foregroundColor1);


        // TypeBox Panel
        JPanel typeBox = new JPanel(new BorderLayout());
        typeBox.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
        typeBox.setBackground(foregroundColor1);


        // Stats Panel
        JPanel statsPanel = new JPanel(new BorderLayout());
        statsPanel.setBorder(BorderFactory.createEmptyBorder(0,0,16,0));
        statsPanel.setBackground(foregroundColor1);

        // Time Passed
        timePassed = new JLabel("Time Passed: 0.00", SwingConstants.CENTER);
        timePassed.setFont(subHeading2);
        timePassed.setForeground(accentColor2);

        // Time Passed
        wpm = new JLabel("00.00 Words per Minute", SwingConstants.CENTER);
        wpm.setFont(subHeading2);
        wpm.setForeground(accentColor2);


        // Text Field
        textField = new JTextField(ghostText, 16);
        textField.setFont(heading2);
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setSize(new Dimension(200, 50));
        textField.setBorder(BorderFactory.createEmptyBorder(32,32,32,32));
        textField.setBackground(accentColor2);
        textField.setHighlighter(null);
        TextFieldListener textFieldListener = new TextFieldListener(app, textField, ghostText);

        // Start Button
//        JButton bStart = new JButton("Submit");
//        bStart.addActionListener(textFieldListener);
//        bStart.setBorder(BorderFactory.createEmptyBorder(32,32,32,32));
//        bStart.setFont(heading2);
//        bStart.setBackground(accentColor1);
//        bStart.setForeground(foregroundColor1);


        // Add to head
        head.add(heading, BorderLayout.CENTER);
        head.add(subHeading, BorderLayout.SOUTH);

        // Add to Stats Panel
        statsPanel.add(timePassed, BorderLayout.WEST);
        statsPanel.add(wpm, BorderLayout.EAST);

        // Add to TypeBox Panel
        typeBox.add(statsPanel, BorderLayout.NORTH);
        typeBox.add(textField, BorderLayout.CENTER);
//        typeBox.add(bStart, BorderLayout.SOUTH);

        // Add to Body Panel
        body.add(typeBox, BorderLayout.CENTER);

        // Add to window
        //window.add(head);
        window.add(body);
        window.setVisible(true);
    }

    private void renderStats() {
        while (true) {
            timePassed.setText("Time Left: " + Math.round((30 - app.countTime()) * 100.0) / 100.0);
            wpm.setText(new SpeedCalculator(app, textField, app.countTime()).calculateSpeed() + " WPM");
        }
    }

    private void calculateSize() {
        while (true) {
            size = window.getBounds().getSize();
        }
    }
}
