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

    private int defAmount = 0;
    private int defMax = 5;
    private int midAmount = 0;
    private int midMax = 5;
    private int forAmount = 0;

    private int goalMax=1;
    private int forMax=3;
    private int y = 20;
    private int playerSize = 45;

    private int playerHeight = 100;

    private int space = 22;

    private int tableWidth = 350;

    private JPanel[] sections = new JPanel[4];

    private ArrayList<JPanel> defenders = new ArrayList<>();
    private ArrayList<JPanel> midfielders = new ArrayList<>();
    private ArrayList<JPanel> forwards = new ArrayList<>();

    private ArrayList<Player> defenders1 = new ArrayList<>();
    private ArrayList<Player> midfielders1 = new ArrayList<>();
    private ArrayList<Player> forwards1 = new ArrayList<>();

    private Player goalkeeper;

    private double width = 350;
    private double height = 550;
    private double pitchWidth = 70;
    private double pitchLength = 110;
    private int i = 0;
    private Color color = Color.WHITE;
    private Stroke stroke = new BasicStroke((float) 0.25);
    public Main() throws SQLException {
        setLayout(null);

        Dimension dimension = new Dimension((int) this.width, (int) this.height);

        Pitch pitch = new Pitch(this.width, this.height, this.pitchWidth, this.pitchLength, this.color, this.stroke);
        pitch.setSize(dimension);
        getContentPane().setBackground(new Color(0, 128, 0));
        for (JPanel p : sections) {
            p = new JPanel();
            p.setLayout(null);
            p.setBounds(0, this.y, (int) this.width, (int) (this.height/4));
            p.setOpaque(false);
            sections[this.i] = p;
            this.i++;

            this.y += this.height/4;
            add(p);
        }

        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel
        Connection conn = DriverManager.getConnection(url);

        String sql = "SELECT name, team, position FROM players order by score desc";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        String position;
        this.i = 0;

        for (int j = 0; j < 11; j++) {
            i++;
            System.out.println(this.defMax + " " + this.midMax + " " + this.forMax);
            rs.next();
            position = rs.getString("position").charAt(0) + "" +rs.getString("position").charAt(1); // hårdkodat

            switch (position){
                case "GK" ->{
                    if (this.goalMax != 0){
                        this.goalkeeper = new Player(rs.getString("name"), rs.getString("team"));
                        this.goalMax--;
                    } else
                        j--;
                }
                case "MF"->{
                    if (midMax == 0){
                        j--;
                    }else {
                        this.midfielders1.add(new Player(rs.getString("name"), rs.getString("team")));
                        this.midMax--;
                        this.midAmount++;

                        if (this.midMax == 0 && this.defMax != 0) this.defMax--;
                        if (this.midMax == 0 && this.forMax != 0) this.forMax--;
                    }

                }
                case "FW"->{
                    if (this.forMax == 0){
                        j--;
                    }else {
                        this.forwards1.add(new Player(rs.getString("name"), rs.getString("team")));
                        this.forMax--;
                        this.forAmount++;

                        if (this.forMax == 0 && this.midMax != 0) this.midMax--;
                        if (this.forMax == 0 && this.defMax != 0) this.defMax--;
                    }
                }
                case "DF"->{
                    if (this.defMax==0){
                        j--;
                    }else {
                        this.defenders1.add(new Player(rs.getString("name"), rs.getString("team")));
                        this.defMax--;
                        this.defAmount++;

                        if (this.defMax == 0 && this.midMax != 0) this.midMax--;
                        if (this.defMax == 0 && this.forMax != 0) this.forMax--;
                    }
                }
            }
        }



        goalkeeper();
        defenders(this.defAmount);
        midfielders(this.midAmount);
        forwards(this.forAmount);

        pitch.setBounds(0,5,(int) dimension.getWidth(),(int) dimension.getHeight());
        add(pitch);

        scrollPane();

        setSize((int) (dimension.getWidth() + this.tableWidth + 17), (int) (dimension.getHeight()+40));
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
        panel.add(image.getImage(this.goalkeeper.getTeam()));
        panel.add(new JLabel(this.goalkeeper.getName()));
        this.sections[3].add(panel);
    }
    public void defenders(int amount){
        int x0= (int) ((this.width - this.space*(amount-1) - this.playerSize*amount)/2);
        Images image = new Images();
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds((x0+(j*(space+playerSize))),20,playerSize,playerHeight);
            panel.setOpaque(false);
            panel.add(image.getImage(defenders1.get(j).getTeam()));
            panel.add(new JLabel(defenders1.get(j).getName()));
            this.sections[2].add(panel);
            this.defenders.add(panel);

        }

    }
    public void midfielders(int amount){
        Images image = new Images();
        int x0 = (int) ((this.width - this.space*(amount-1) - this.playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds((x0+(j*(this.space + this.playerSize))),20, this.playerSize, this.playerHeight);
            panel.setOpaque(false);
            panel.add(image.getImage(this.midfielders1.get(j).getTeam()));
            panel.add(new JLabel(this.midfielders1.get(j).getName()));
            this.sections[1].add(panel);
            this.midfielders.add(panel);
        }

    }
    public void forwards(int amount){
        Images image = new Images();
        int x0 = (int) ((this.width - this.space*(amount-1) - this.playerSize*amount)/2);
        for (int j = 0; j < amount; j++) {
            JPanel panel = new JPanel();
            panel.setBounds(x0 + (j*(this.space + this.playerSize)),20, this.playerSize, this.playerHeight);
            panel.setOpaque(false);
            panel.add(image.getImage(this.forwards1.get(j).getTeam()));
            panel.add(new JLabel(this.forwards1.get(j).getName()));
            this.sections[0].add(panel);
            this.forwards.add(panel);
        }
    }


    public void scrollPane() throws SQLException {
        String[] columnNames = {"Name","Team","Position","score"};

        String[][] list = new String[553][4];
        String sql = "SELECT name, team, position, score FROM players order by score desc";

        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel

        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        int count=0;

        // loop through the result set
        while (rs.next()) {
            double score = rs.getDouble("score");
            DecimalFormat format = new DecimalFormat("0.0000");
            String position = rs.getString("position").charAt(0)+ "" + rs.getString("position").charAt(1);
            list[count]= new String[]{rs.getString("name"), rs.getString("team"), position, format.format(score)};
            count++;
        }

        JPanel p;
        p = new JPanel();
        p.setLayout(null);
        p.setOpaque(false);
        p.setBounds((int) this.width,0, this.tableWidth, (int) this.height);
        JTable table = new JTable(list, columnNames);
        table.setFocusable(false);
        table.setBounds(0,0, this.tableWidth, (int) this.height);
        System.out.println(this.width+ " " + this.height);
        resizeColumnWidth(table);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,0, this.tableWidth, (int) this.height);
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
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300)
                width = 300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

}
