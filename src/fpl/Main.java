package fpl;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        setLayout(null);


        Dimension dimension = new Dimension(550, 350);

        double width = 550d;
        double height = 350d;
        double pitchWidth = 70d;
        double pitchLength = 110d;
        Color color = Color.WHITE;
        Stroke stroke = new BasicStroke(5/36);

        Pitch pitch = new Pitch(width, height, pitchWidth, pitchLength, color, stroke);
        pitch.setSize(dimension);
        add(pitch);

        setSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
