package fpl.algorithms;

import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;

public class VikAlgorithm {
    private String name;
    private String position;
    private String team;
    private int matchesPlayed;
    private int starts;
    private int minutes;
    private int goals;
    private int assists;
    private int penalties;
    private int yellows;
    private int reds;
    private int prgC;
    private int prgP;
    private int prgR;
    private int touches;
    private int touchesAttackingThird;
    private int touchesAttackingBox;
    private int minutesPerMatch;
    private int goalsAllowed;
    private int tackles;
    private int tacklesWon;
    private int defensiveErrors;
    private int shortPassesCompleted;
    private int mediumPassesCompleted;
    private int keyPasses;
    private int passesFinalThird;
    private int passesBox;
    private double xG;
    private double xAG;
    private double xGA;
    private double shortPassesPercentage;
    private double mediumPassesPercentage;
    private double score = 0.0;
    ArrayList<String> list = new ArrayList();
    double[] scores = new double[550];

    public static void main(String[] args) throws SQLException, InterruptedException {
        new VikAlgorithm();
    }

    public VikAlgorithm() throws SQLException, InterruptedException {
        list.add("Matches_Played");
        list.add("starts");
        list.add("minutes");
        list.add("goals");
        list.add("assists");
        list.add("penalties");
        list.add("yellows");
        list.add("reds");
        list.add("xG");
        list.add("xAG");
        list.add("prgC");
        list.add("prgP");
        list.add("prgR");
        list.add("touches");
        list.add("touches_attacking_third");
        list.add("touches_attacking_box");
        list.add("minutes_per_match");
        list.add("goalsallowed");
        list.add("xGA");
        list.add("tackles");
        list.add("tacklesWon");
        list.add("defensive_errors");
        list.add("shortpasses_completed");
        list.add("shortpasses_percent");
        list.add("mediumpasses_completed");
        list.add("mediumpasses_percent");
        list.add("key_passes");
        list.add("passes_final_third");
        list.add("passes_box");
        ArrayList<Highest> parameters = new ArrayList();

        for(int i = 0; i < this.list.size(); ++i) {
            parameters.add(new Highest((String)this.list.get(i)));
            ((Highest)parameters.get(i)).print();
        }

        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db";
        String sql = "SELECT * from players";
        Connection connection = DriverManager.getConnection(url);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        int playerId = 0;

        while(rs.next()) {
            PrintStream var10000 = System.out;
            String var10001 = rs.getString("name");
            var10000.print(var10001 + "|" + rs.getString("position") + "|");
            char var12 = rs.getString("position").charAt(0);
            String pos = "" + var12 + rs.getString("position").charAt(1);
            matchesPlayed = rs.getInt("matches_played");
            starts = rs.getInt("starts");
            minutes = rs.getInt("minutes");
            goals = rs.getInt("goals");
            assists = rs.getInt("assists");
            penalties = rs.getInt("penalties");
            yellows = rs.getInt("yellows");
            reds = rs.getInt("reds");
            prgC = rs.getInt("prgC");
            prgP = rs.getInt("prgP");
            prgR = rs.getInt("prgR");
            touches = rs.getInt("touches");
            touchesAttackingThird = rs.getInt("touches_Attacking_Third");
            touchesAttackingBox = rs.getInt("touches_Attacking_Box");
            minutesPerMatch = rs.getInt("minutes_Per_Match");
            goalsAllowed = rs.getInt("goalsAllowed");
            tackles = rs.getInt("tackles");
            tacklesWon = rs.getInt("tacklesWon");
            defensiveErrors = rs.getInt("defensive_Errors");
            shortPassesCompleted = rs.getInt("shortPasses_Completed");
            mediumPassesCompleted = rs.getInt("mediumPasses_Completed");
            keyPasses = rs.getInt("key_Passes");
            passesFinalThird = rs.getInt("passes_Final_Third");
            passesBox = rs.getInt("passes_Box");
            xG = rs.getDouble("xG");
            xAG = rs.getDouble("xAG");
            xGA = rs.getDouble("xGA");
            shortPassesPercentage = rs.getDouble("shortPasses_Percent");
            mediumPassesPercentage = rs.getDouble("mediumPasses_Percent");
            ++playerId;
            if (!pos.equals("GK")) {
                switch (pos) {
                    case "MF":
                        this.calcMidfielder(playerId, statement);
                        break;
                    case "DF":
                        this.calcDefender(playerId, statement);
                        break;
                    case "FW":
                        this.calcForward(playerId, statement);
                }
            }
        }

    }

    private void calcForward(int id, PreparedStatement statement) throws InterruptedException {
        try {
            System.out.println("h");
            Thread.sleep(100L);
            //this.scores[id - 1] = 0.0;
            System.out.println(id);
            //statement.setInt(1, (int) this.score);
            //statement.setInt(2, id);
            statement.executeUpdate();
            Thread.sleep(3000L);
        } catch (SQLException e) {
            // handle the SQL exception
            e.printStackTrace();
        }
    }

    private void calcMidfielder(int id, Statement statement) {
        System.out.println("hs");
        this.scores[id - 1] = 0.0;
        System.out.println(id);
    }

    public void calcDefender(int id, Statement statement) {
        System.out.println("ha");
        this.scores[id - 1] = 0.0;
        System.out.println(id);
    }

}
