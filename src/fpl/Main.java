package fpl;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        setLayout(null);

        final int touchline = 1200;
        final int goalLine = 650;
        Dimension dimension = new Dimension(touchline, goalLine);

        final Color color = Color.GREEN;

        Pitch pitch = new Pitch(touchline, goalLine, color);
        pitch.setSize(dimension);
        add(pitch);

        setSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
