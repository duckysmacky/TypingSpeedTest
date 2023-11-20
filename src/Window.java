import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Window extends Frame {
    private JFrame window;
    private JLabel label;

    public Window() {
        window = new JFrame();

        window.setTitle("Typing Speed Test");
        window.setSize(512, 512);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Text");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);

        while (true) {
            render();
        }

    }

    private void render() {
        label.setSize(100, 50);

        window.add(label, SwingConstants.CENTER);
        window.setVisible(true);
    }

}
