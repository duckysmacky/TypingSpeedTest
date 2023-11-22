package main;

public class App {
    private final Window window;

    public App() {

        window = new Window(this);

    }

    public static void main(String[] args) {

        new App();

    }

    public Window getWindow() {
        return this.window;
    }
}