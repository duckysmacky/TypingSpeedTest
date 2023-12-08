package main;

public class Timer {
    private App app;
    private int maxTime = 30;
    private double time = 0;
    private long lastTime = 0;

    public Timer(App app) {

        this.app = app;
        countTime();

    }

    public double countTime() {
        if (app.getState() == 1) {
            if (System.currentTimeMillis() - lastTime >= 10) {
                lastTime = System.currentTimeMillis();
                //System.out.println("Second passed: " + System.currentTimeMillis());
                time += 0.01;
                time = Math.round(time * 100.0) / 100.0;
                //System.out.println(time);
            }
        }

        return time;
    }
    // Setters and Getters

    public void setTimeLeft(double value) { this.time = value; }
}
