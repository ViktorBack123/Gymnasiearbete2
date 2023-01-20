package fpl;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        setLayout(null);

        final int pitchLength = 550;
        final int pitchWidth = 350;
        Dimension dimension = new Dimension(pitchWidth, pitchLength);



        final Color color = Color.GREEN;

        Pitch pitch = new Pitch();
        pitch.setSize(dimension);
        add(pitch);

        setSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
