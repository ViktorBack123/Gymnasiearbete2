package fpl;

import javax.swing.*;

public class Pitch extends JPanel {
    private final int touchline;
    private final int goalLine;

    public Pitch(int touchline, int goalLine) {
        this.touchline = touchline;
        this.goalLine = goalLine;
    }
}
