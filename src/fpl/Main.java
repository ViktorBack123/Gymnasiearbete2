package fpl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{
    public static void main(String[] args) {
        new Main();
    }

    int defAmount=5;
    int midAmount=3;
    int forAmount=2;
    int y=20;
    int playerSize = 45;

    int playerHeight = 80;

    int space=22;

    JPanel[] sections = new JPanel[4];

    ArrayList<JPanel> defenders = new ArrayList<>();
    ArrayList<JPanel> midfielders = new ArrayList<>();
    ArrayList<JPanel> forwards = new ArrayList<>();

    ArrayList<Player> defenders1 = new ArrayList<>();
    ArrayList<Player> midfielders1 = new ArrayList<>();
    ArrayList<Player> forwards1 = new ArrayList<>();

        double width = 350;
        double height = 550;
        double pitchWidth = 70;
        double pitchLength = 110;
        int i=0;
    public Main() {
        setLayout(null);


        Dimension dimension = new Dimension((int) width, (int) height);

        Color color = Color.WHITE;
        Stroke stroke = new BasicStroke((float) 0.25);

        // VAD HÄNDER

        Pitch pitch = new Pitch(width, height, pitchWidth, pitchLength, color, stroke);
        pitch.setSize(dimension);
        getContentPane().setBackground(new Color(0, 128, 0));
        for (JPanel p:sections) {
            p=new JPanel();
            p.setLayout(null);
            p.setBounds(0,y, (int) width, (int) (height/4));
            p.setOpaque(false);
            sections[i]=p;
            i++;


            y+=height/4;
            add(p);
        }
        goalie();
        defenders(defAmount);
        midfielders(midAmount);
        forwards(forAmount);
        pitch.setBounds(0,5,(int)dimension.getWidth(),(int)dimension.getHeight());
        add(pitch);


        setSize((int) (dimension.getWidth()+10), (int) (dimension.getHeight()+50));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public void goalie(){
        JPanel panel = new JPanel();

        panel.setBounds((int) width/2-playerSize/2,20,playerSize,playerHeight);
        panel.setBackground(Color.gray);
        sections[3].add(panel);
    }
    public void defenders(int amount){
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds((x0+(j*(space+playerSize))),20,playerSize,playerHeight);
            panel.setBackground(Color.gray);
            sections[2].add(panel);
            defenders.add(panel);

        }

    }
    public void midfielders(int amount){
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds((x0+(j*(space+playerSize))),20,playerSize,playerHeight);
            panel.setBackground(Color.gray);
            sections[1].add(panel);
            midfielders.add(panel);
        }

    }
    public void forwards(int amount){
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds(x0+(j*(space+playerSize)),20,playerSize,playerHeight);
            panel.setBackground(Color.gray);
            sections[0].add(panel);
            forwards.add(panel);
        }
    }

    public void newPlayer(JPanel panel){

    }
}
