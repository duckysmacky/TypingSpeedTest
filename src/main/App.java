package main;

public class App {
    private final Timer timer;
    private final Window window;
    private int state;

    public App() {

        this.timer = new Timer(this);
        this.window = new Window(this);
        this.state = 0;

    }

    public static void main(String[] args) {

        System.out.println("App started");

        new App();

    }

    // Setters and Getters
    public void setState(int state) { this.state = state; }

    public Timer getTimer() { return this.timer; }
    public Window getWindow() { return this.window; }
    public int getState() { return this.state; }
}