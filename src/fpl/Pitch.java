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

    public Pitch() {
        setBackground(new Color(0, 128, 0));
        setPreferredSize(new Dimension(550, 350));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        double width = getWidth();
        double height = getHeight();
        double pitchWidth = 70d;
        double pitchLength = 110d;
        double scaleWidth = pitchWidth+2;
        double scaleHeight = pitchLength+2;
        double scale;
        if((width/height) >= (110d/70d)) {
            scale = height/scaleHeight;
        } else {
            scale = width/scaleWidth;
        }
        g2.scale(scale, scale);
        g2.translate(1, 1);
        g2.setColor(Color.WHITE);
        Stroke stroke = new BasicStroke(5/36);
        g2.setStroke(stroke);
        drawTouchLines(g2, pitchWidth, pitchLength);
        drawGoalLines(g2, pitchWidth, pitchLength);
        drawCenterLine(g2, pitchWidth, pitchLength);
        drawCenterCircle(g2, pitchWidth, pitchLength);
        drawCenterMark(g2, pitchWidth, pitchLength);
        drawCornerArches(g2, pitchWidth, pitchLength);
        drawGoals(g2, pitchWidth, pitchLength);
        drawGoalAreas(g2, pitchWidth, pitchLength);
        drawPenaltyAreas(g2, pitchWidth, pitchLength);
        drawPenaltyMarks(g2, pitchWidth, pitchLength);
        drawPenaltyArches(g2, pitchWidth, pitchLength);
    }

    private void drawPenaltyArches(Graphics2D g2, double pitchWidth,
                                   double pitchLength) {
//		double extent = 2*Math.toDegrees(Math.acos(6d/10d));
        double extent = 106.26020470831196d;
        g2.draw(new Arc2D.Double((pitchWidth/2)-10, pitchLength-12-10, 20, 20, 90-(extent/2), extent, Arc2D.OPEN));
        g2.draw(new Arc2D.Double((pitchWidth/2)-10, 12-10, 20, 20, 270-(extent/2), extent, Arc2D.OPEN));
    }

    private void drawPenaltyMarks(Graphics2D g2, double pitchWidth,
                                  double pitchLength) {
        g2.fill(new Ellipse2D.Double((pitchWidth/2)-(10d/36), pitchLength-12-(10d/36), (20d/36), (20d/36)));
        g2.fill(new Ellipse2D.Double((pitchWidth/2)-(10d/36), 12-(10d/36), (20d/36), (20d/36)));
    }

    private void drawPenaltyAreas(Graphics2D g2, double pitchWidth,
                                  double pitchLength) {
        g2.draw(new Rectangle2D.Double((pitchWidth/2)-22, 0, 42, 18));
        g2.draw(new Rectangle2D.Double((pitchWidth/2)-22, pitchLength-18, 42, 18));
    }

    private void drawGoalAreas(Graphics2D g2, double pitchWidth,
                               double pitchLength) {
        g2.draw(new Rectangle2D.Double((pitchWidth/2)-10, 0, 20, 6));
        g2.draw(new Rectangle2D.Double((pitchWidth/2)-10, pitchLength-6, 20, 6));
    }

    private void drawGoals(Graphics2D g2, double pitchWidth, double pitchLength) {
        g2.draw(new Rectangle2D.Double((pitchWidth/2)-4, -1, 8, 1));
        g2.draw(new Rectangle2D.Double((pitchWidth/2)-4, pitchLength, 8, 1));
    }

    private void drawCornerArches(Graphics2D g2, double pitchWidth,
                                  double pitchLength) {
        g2.draw(new Arc2D.Double(-1, -1, 2, 2, 270, 90, Arc2D.OPEN));
        g2.draw(new Arc2D.Double(pitchWidth-1, -1, 2, 2, 180, 90, Arc2D.OPEN));
        g2.draw(new Arc2D.Double(pitchWidth-1, pitchLength-1, 2, 2, 90, 90, Arc2D.OPEN));
        g2.draw(new Arc2D.Double(-1, pitchLength-1, 2, 2, 0, 90, Arc2D.OPEN));
    }

    private void drawCenterMark(Graphics2D g2, double pitchWidth,
                                double pitchLength) {
        g2.fill(new Ellipse2D.Double((pitchWidth/2)-(10d/36), (pitchLength/2)-(10d/36), (20d/36), (20d/36)));
    }

    private void drawCenterCircle(Graphics2D g2, double pitchWidth,
                                  double pitchLength) {
        g2.draw(new Ellipse2D.Double((pitchWidth/2)-10, (pitchLength/2)-10, 20, 20));
    }

    private void drawCenterLine(Graphics2D g2, double pitchWidth,
                                double pitchLength) {
        g2.draw(new Line2D.Double(0,pitchLength/2, pitchWidth, pitchLength/2));
    }

    private void drawGoalLines(Graphics2D g2, double pitchWidth,
                               double pitchLength) {
        g2.draw(new Line2D.Double(0, 0, 0, pitchLength));
        g2.draw(new Line2D.Double(pitchWidth, 0, pitchWidth, pitchLength));
    }

    private void drawTouchLines(Graphics2D g2, double pitchWidth,
                                double pitchLength) {
        g2.draw(new Line2D.Double(0, 0, pitchWidth, 0));
        g2.draw(new Line2D.Double(0, pitchLength, pitchWidth, pitchLength));
    }
}