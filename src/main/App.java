package main;

public class App {
    private final Window window;
    private double time = 0;
    private long lastTime = 0;

    public App() {

        window = new Window(this);
        countTime();

    }

    public static void main(String[] args) {

        System.out.println("App started");

        new App();

    }

    public double countTime() {
        if (System.currentTimeMillis() - lastTime >= 10) {
            lastTime = System.currentTimeMillis();
            //System.out.println("Second passed: " + System.currentTimeMillis());
            time += 0.01;
            time = Math.round(time * 100.0) / 100.0;
            //System.out.println(time);
        }
        return time;
    }

    public void setTime(double value) { time = value; }
    public Window getWindow() { return this.window; }
}