package fpl;

import javax.swing.*;
import java.awt.*;

public class Pitch extends JPanel {
    private final int touchline;
    private final int goalLine;
    private final Color color;


    public Pitch(int touchline, int goalLine, Color color) {
        this.touchline = touchline;
        this.goalLine = goalLine;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);


    }
}
