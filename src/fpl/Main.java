package fpl;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    int defAmount;
    int midAmount;
    int forAmount;
    int y;
    int playerSize = 100;

    JPanel[] sections = new JPanel[4];

        double width = 700;
        double height = 1100;
        double pitchWidth = 70;
        double pitchLength = 110;
        int i=0;
    public Main() {
        setLayout(null);


        Dimension dimension = new Dimension((int) width, (int) height);

        Color color = Color.WHITE;
        Stroke stroke = new BasicStroke(5/36);

        Pitch pitch = new Pitch(width, height, pitchWidth, pitchLength, color, stroke,this);
        pitch.setSize(dimension);
        for (JPanel p:sections) {
            p=new JPanel();
            p.setLayout(null);
            p.setPreferredSize(new Dimension(1100/4,700));
            p.setBounds(0,y,700,1100/4);
            p.setOpaque(false);
            p.setBackground(Color.red);
            sections[i]=p;
            i++;


            y+=1100/4;
            add(p);
        }
        goalie();
        add(pitch);


        setSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void goalie(){
        JPanel panel = new JPanel();

        panel.setBounds((int) width/2-playerSize/2,20,playerSize,playerSize+100);
        System.out.println(getWidth());
        panel.setBackground(Color.gray);
        sections[3].add(panel);
    }
    public void defenders(int amount){

    }
    public void midfielders(int amount){

    }
    public void forwards(int amount){

    }

    public void newPlayer(JPanel panel){

    }

}
