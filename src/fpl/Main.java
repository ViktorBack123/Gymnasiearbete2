package fpl;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class Main extends JFrame{
    public static void main(String[] args) throws SQLException {
        new Main();
    }

    int defAmount = 0;
    int midAmount = 0;
    int forAmount = 0;
    int y = 20;
    int playerSize = 45;

    int playerHeight = 100;

    int space = 22;

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
        int i = 0;
    public Main() throws SQLException {
        setLayout(null);


        Dimension dimension = new Dimension((int) width, (int) height);

        Color color = Color.WHITE;
        Stroke stroke = new BasicStroke((float) 0.25);

        // VAD HÄNDER

        Pitch pitch = new Pitch(width, height, pitchWidth, pitchLength, color, stroke);
        pitch.setSize(dimension);
        getContentPane().setBackground(new Color(0, 128, 0));
        for (JPanel p : sections) {
            p=new JPanel();
            p.setLayout(null);
            p.setBounds(0,y, (int) width, (int) (height/4));
            p.setOpaque(false);
            sections[i]=p;
            i++;


            y+=height/4;
            add(p);
        }

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        //String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel
        Connection conn = DriverManager.getConnection(url);
        String sql = "SELECT name, team, position FROM players order by score desc";

        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);

        String position;

        for (int j = 0; j < 11; j++) {
            rs.next();
            position=rs.getString("position").charAt(0)+""+rs.getString("position").charAt(1);


            switch (position){
                case "MF"->{
                    if (midAmount==5){
                        j--;
                    }else {
                        midfielders1.add(new Player(rs.getString("name"), rs.getString("team")));
                        midAmount++;
                    }
                }
                case "FW"->{
                    if (forAmount == 3){
                        j--;
                    }else {
                        forwards1.add(new Player(rs.getString("name"), rs.getString("team")));
                        forAmount++;
                    }
                }
                case "DF"->{
                    if (defAmount==5){
                        j--;
                    }else {
                        defenders1.add(new Player(rs.getString("name"), rs.getString("team")));
                        defAmount++;
                    }
                }
            }
        }



        goalkeeper();
        defenders(defAmount);
        midfielders(midAmount);
        forwards(forAmount);
        pitch.setBounds(0,5,(int) dimension.getWidth(),(int) dimension.getHeight());
        add(pitch);


        setSize((int) (dimension.getWidth()+10), (int) (dimension.getHeight()+50));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void goalkeeper(){
        Images image = new Images();
        JPanel panel = new JPanel();

        panel.setBounds((int) width/2-playerSize/2,20,playerSize,playerHeight);
        panel.setOpaque(false);
        panel.add(image.getImage("Brighton"));
        sections[3].add(panel);
    }
    public void defenders(int amount){
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        Images image = new Images();
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds((x0+(j*(space+playerSize))),20,playerSize,playerHeight);
            panel.setOpaque(false);
            panel.add(image.getImage(defenders1.get(j).getTeam()));
            panel.add(new JLabel(defenders1.get(j).getName()));
            sections[2].add(panel);
            defenders.add(panel);

        }

    }
    public void midfielders(int amount){
        Images image = new Images();
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds((x0+(j*(space+playerSize))),20,playerSize,playerHeight);
            panel.setOpaque(false);
            panel.add(image.getImage(midfielders1.get(j).getTeam()));
            panel.add(new JLabel(midfielders1.get(j).getName()));
            sections[1].add(panel);
            midfielders.add(panel);
        }

    }
    public void forwards(int amount){
        Images image = new Images();
        int x0= (int) ((width-space*(amount-1)-playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds(x0+(j*(space+playerSize)),20,playerSize,playerHeight);
            panel.setOpaque(false);
            panel.add(image.getImage(forwards1.get(j).getTeam()));
            panel.add(new JLabel(forwards1.get(j).getName()));
            sections[0].add(panel);
            forwards.add(panel);
        }
    }
}
