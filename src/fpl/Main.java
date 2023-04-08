package fpl;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main extends JFrame{
    public static void main(String[] args) throws SQLException {
        new Main();
    }

    int defAmount = 0;
    int defMax = 5;
    int midAmount = 0;
    int midMax = 5;
    int forAmount = 0;

    int goalMax=1;
    int forMax=3;
    int y = 20;
    int playerSize = 45;

    int playerHeight = 100;

    int space = 22;

    int tableWidth = 350;

    JPanel[] sections = new JPanel[4];

    ArrayList<JPanel> defenders = new ArrayList<>();
    ArrayList<JPanel> midfielders = new ArrayList<>();
    ArrayList<JPanel> forwards = new ArrayList<>();

    ArrayList<Player> defenders1 = new ArrayList<>();
    ArrayList<Player> midfielders1 = new ArrayList<>();
    ArrayList<Player> forwards1 = new ArrayList<>();

    Player goalkeeper;

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
        i=0;

        for (int j = 0; j < 11; j++) {
            i++;
            System.out.println(defMax+" "+midMax+" "+forMax);
            rs.next();
            position=rs.getString("position").charAt(0)+""+rs.getString("position").charAt(1);


            switch (position){
                case "GK" ->{
                    if (goalMax!=0){
                        goalkeeper = new Player(rs.getString("name"), rs.getString("team"));
                        goalMax--;
                    }else
                        j--;
                }
                case "MF"->{
                    if (midMax==0){
                        j--;
                    }else {
                        midfielders1.add(new Player(rs.getString("name"), rs.getString("team")));
                        midMax--;
                        midAmount++;

                        if (midMax==0&&defMax!=0)defMax--;
                        if (midMax==0&&forMax!=0)forMax--;
                    }

                }
                case "FW"->{
                    if (forMax == 0){
                        j--;
                    }else {
                        forwards1.add(new Player(rs.getString("name"), rs.getString("team")));
                        forMax--;
                        forAmount++;
                        if (forMax==0&&midMax!=0)midMax--;
                        if (forMax==0&&defMax!=0)defMax--;
                    }
                }
                case "DF"->{
                    if (defMax==0){
                        j--;
                    }else {
                        defenders1.add(new Player(rs.getString("name"), rs.getString("team")));
                        defMax--;
                        defAmount++;

                        if (defMax==0&&midMax!=0)midMax--;
                        if (defMax==0&&forMax!=0)forMax--;
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

        scrollPane();

        setSize((int) (dimension.getWidth()+tableWidth+17), (int) (dimension.getHeight()+40));
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
        panel.add(image.getImage(goalkeeper.getTeam()));
        panel.add(new JLabel(goalkeeper.getName()));
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


    public void scrollPane() throws SQLException {
        String[] columnNames = {"Name","Team","Position","score"};


        String[][] list = new String[550][4];
        String sql = "SELECT name, team, position, score FROM players order by score desc";

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

        Connection conn = DriverManager.getConnection(url);
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        int count=0;

            // loop through the result set
            while (rs.next()) {
                double score = rs.getDouble("score");
                DecimalFormat format = new DecimalFormat("0.000");
                String position = rs.getString("position").charAt(0)+""+rs.getString("position").charAt(1);
                list[count]= new String[]{rs.getString("name"), rs.getString("team"), position, format.format(score)};
                count++;
            }

            JPanel p;
            p=new JPanel();
            p.setLayout(null);
            p.setOpaque(false);
            p.setBounds((int) width,0,tableWidth,(int) height);
            JTable table = new JTable(list,columnNames);
            table.setBounds(0,0,tableWidth,(int)height);
            System.out.println(width+" " + height);
            resizeColumnWidth(table);

            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(0,0,tableWidth,(int)height);
            p.add(pane);
            add(p);



    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

}
