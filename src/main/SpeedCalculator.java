package main;

import javax.swing.*;

public class SpeedCalculator {
    private App app;
    private final JTextField textField;
    private double time;

    SpeedCalculator(App app, JTextField textField, double time) {
        this.app = app;
        this.textField = textField;
        this.time = time;
    }

    public double calculateSpeed() {
        double speed = 0;
        if (app.getState() == 1) {
            String text = textField.getText().replace("\t", "");
            speed = (text.length() / 5) / time * 100;
        }
        return Math.round(speed * 100.0) / 100.0;
    }
}
