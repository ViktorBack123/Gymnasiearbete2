package fpl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{
    public static void main(String[] args) {
        new Main();
    }

    int defAmount;
    int midAmount;
    int forAmount;
    int y=20;
    int playerSize = 90;

    int space=45;

    JPanel[] sections = new JPanel[4];

    ArrayList<JPanel> defenders = new ArrayList<>();
    ArrayList<JPanel> midfielders = new ArrayList<>();
    ArrayList<JPanel> forwards = new ArrayList<>();

    ArrayList<Player> defenders1 = new ArrayList<>();
    ArrayList<Player> midfielders1 = new ArrayList<>();
    ArrayList<Player> forwards1 = new ArrayList<>();

        double width = 700;
        double height = 1100;
        double pitchWidth = 70;
        double pitchLength = 110;
        int i=0;
    public Main() {
        setLayout(null);


        Dimension dimension = new Dimension((int) width, (int) height);

        Color color = Color.WHITE;
        Stroke stroke = new BasicStroke((float) 0.25);

        Pitch pitch = new Pitch(width, height, pitchWidth, pitchLength, color, stroke,this);
        pitch.setSize(dimension);
        getContentPane().setBackground(new Color(0, 128, 0));
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
        defenders(5);
        midfielders(2);
        forwards(3);
        pitch.setBounds(0,5,(int)dimension.getWidth(),(int)dimension.getHeight());
        add(pitch);


        setSize((int) (dimension.getWidth()+5), (int) (dimension.getHeight()+25));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public void goalie(){
        JPanel panel = new JPanel();

        panel.setBounds((int) width/2-playerSize/2,20,playerSize,playerSize+100);
        panel.setBackground(Color.gray);
        sections[3].add(panel);
    }
    public void defenders(int amount){
        int m=0;
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds((x0+(m*(space+playerSize))),20,playerSize,playerSize+100);
            panel.setBackground(Color.gray);
            sections[2].add(panel);
            defenders.add(panel);
            m++;

        }

    }
    public void midfielders(int amount){
        int m=0;
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds((x0+(m*(space+playerSize))),20,playerSize,playerSize+100);
            panel.setBackground(Color.gray);
            sections[1].add(panel);
            midfielders.add(panel);
            m++;
        }

    }
    public void forwards(int amount){
        int m=0;
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds(x0+(m*(space+playerSize)),20,playerSize,playerSize+100);
            panel.setBackground(Color.gray);
            sections[0].add(panel);
            forwards.add(panel);
            m++;
        }
    }

    public void newPlayer(JPanel panel){

    }
}
