package main;

import javax.swing.*;

public class SpeedCalculator {
    private final JTextField textField;
    private double time;

    SpeedCalculator(JTextField textField, double time) {
        this.textField = textField;
        this.time = time;
    }

    private double calculateSpeed() {
        String text = textField.getText().replace("\t", "");
        return 0;
    }
}