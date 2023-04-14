package fpl;

import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Pitch extends JPanel {
        private final double width;
        private final double height;
        private final double pitchWidth;
        private final double pitchLength;
        private final Color lineColor;
        private final Stroke stroke;

        private JFrame frame;
    public Pitch(double width, double height, double pitchWidth, double pitchLength, Color lineColor, Stroke stroke) {
        this.frame = frame; // behövs detta verkligen
        this.width = width;
        this.height = height;
        this.pitchWidth = pitchWidth;
        this.pitchLength = pitchLength;
        this.lineColor = lineColor;
        this.stroke = stroke;

        setBackground(new Color(0, 128, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        double scaleWidth = this.pitchWidth+3;
        double scale;
        if((this.width/this.height) >= (110/70)) {
            scale = height/ this.pitchLength;
        } else {
            scale = this.width/scaleWidth;
        }
        g2.scale(scale, scale);

        g2.translate(1, 1);
        g2.setColor(this.lineColor);
        g2.setStroke(this.stroke);
        drawTouchLines(g2);
        drawGoalLines(g2);
        drawCenterLine(g2);
        drawCenterCircle(g2);
        drawCenterMark(g2);
        drawCornerArches(g2);
        drawGoals(g2);
        drawGoalAreas(g2);
        drawPenaltyAreas(g2);
        drawPenaltyMarks(g2);
        drawPenaltyArches(g2);
    }

    private void drawTouchLines(Graphics2D g2) {
        g2.draw(new Line2D.Double(0, 0, this.pitchWidth, 0));
        g2.draw(new Line2D.Double(0, this.pitchLength, this.pitchWidth, this.pitchLength));
    }

    private void drawGoalLines(Graphics2D g2) {
        g2.draw(new Line2D.Double(0, 0, 0, this.pitchLength));
        g2.draw(new Line2D.Double(this.pitchWidth, 0, this.pitchWidth, this.pitchLength));
    }

    private void drawCenterLine(Graphics2D g2) {
        g2.draw(new Line2D.Double(0,this.pitchLength/2, this.pitchWidth, this.pitchLength/2));
    }

    private void drawCenterCircle(Graphics2D g2) {
        g2.draw(new Ellipse2D.Double((this.pitchWidth/2)-10, (this.pitchLength/2)-10, 20, 20));
    }

    private void drawCenterMark(Graphics2D g2) {
        g2.fill(new Ellipse2D.Double((this.pitchWidth/2)-(10d/36), (this.pitchLength/2)-(10d/36), (20d/36), (20d/36)));
    }

    private void drawCornerArches(Graphics2D g2) {
        g2.draw(new Arc2D.Double(-1, -1, 2, 2, 270, 90, Arc2D.OPEN));
        g2.draw(new Arc2D.Double(this.pitchWidth-1, -1, 2, 2, 180, 90, Arc2D.OPEN));
        g2.draw(new Arc2D.Double(this.pitchWidth-1, this.pitchLength-1, 2, 2, 90, 90, Arc2D.OPEN));
        g2.draw(new Arc2D.Double(-1, this.pitchLength-1, 2, 2, 0, 90, Arc2D.OPEN));
    }

    private void drawGoals(Graphics2D g2) {
        g2.draw(new Rectangle2D.Double((this.pitchWidth/2)-4, -1, 8, 1));
        g2.draw(new Rectangle2D.Double((this.pitchWidth/2)-4, this.pitchLength, 8, 1));
    }

    private void drawGoalAreas(Graphics2D g2) {
        g2.draw(new Rectangle2D.Double((this.pitchWidth/2)-10, 0, 20, 6));
        g2.draw(new Rectangle2D.Double((this.pitchWidth/2)-10, this.pitchLength-6, 20, 6));
    }

    private void drawPenaltyAreas(Graphics2D g2) {
        g2.draw(new Rectangle2D.Double((this.pitchWidth/2)-22, 0, 42, 18));
        g2.draw(new Rectangle2D.Double((this.pitchWidth/2)-22, this.pitchLength-18, 42, 18));
    }

    private void drawPenaltyMarks(Graphics2D g2) {
        g2.fill(new Ellipse2D.Double((this.pitchWidth/2)-(10d/36), this.pitchLength-12-(10d/36), (20d/36), (20d/36)));
        g2.fill(new Ellipse2D.Double((this.pitchWidth/2)-(10d/36), 12-(10d/36), (20d/36), (20d/36)));
    }

    private void drawPenaltyArches(Graphics2D g2) {
	    double extent = 2*Math.toDegrees(Math.acos(6d/10d));
        g2.draw(new Arc2D.Double((this.pitchWidth/2)-10, this.pitchLength-12-10, 20, 20, 90-(extent/2), extent, Arc2D.OPEN));
        g2.draw(new Arc2D.Double((this.pitchWidth/2)-10, 12-10, 20, 20, 270-(extent/2), extent, Arc2D.OPEN));
    }
}