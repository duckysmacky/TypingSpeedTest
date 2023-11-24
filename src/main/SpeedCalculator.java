package main;

import javax.swing.*;

public class SpeedCalculator {
    private final JTextField textField;
    private double time;

    SpeedCalculator(JTextField textField, double time) {
        this.textField = textField;
        this.time = time;
    }

    public double calculateSpeed() {
        String text = textField.getText().replace("\t", "");
        double speed = (text.length() / 5) / time * 100;
        return Math.round(speed * 100.0) / 100.0;
    }
}
