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
    Connection conn;

    public static void main(String[] args) throws SQLException, InterruptedException {
        new VikAlgorithm();
    }

    public VikAlgorithm() throws SQLException, InterruptedException {
        this.list.add("Matches_Played");
        this.list.add("starts");
        this.list.add("minutes");
        this.list.add("goals");
        this.list.add("assists");
        this.list.add("penalties");
        this.list.add("yellows");
        this.list.add("reds");
        this.list.add("xG");
        this.list.add("xAG");
        this.list.add("prgC");
        this.list.add("prgP");
        this.list.add("prgR");
        this.list.add("touches");
        this.list.add("touches_attacking_third");
        this.list.add("touches_attacking_box");
        this.list.add("minutes_per_match");
        this.list.add("goalsallowed");
        this.list.add("xGA");
        this.list.add("tackles");
        this.list.add("tacklesWon");
        this.list.add("defensive_errors");
        this.list.add("shortpasses_completed");
        this.list.add("shortpasses_percent");
        this.list.add("mediumpasses_completed");
        this.list.add("mediumpasses_percent");
        this.list.add("key_passes");
        this.list.add("passes_final_third");
        this.list.add("passes_box");
        ArrayList<Highest> parameters = new ArrayList();

        for(int i = 0; i < this.list.size(); ++i) {
            parameters.add(new Highest((String)this.list.get(i)));
            ((Highest)parameters.get(i)).print();
        }

        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db";
        String sql = "SELECT * from players";
        conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        int playerId = 0;


        while(rs.next()) {
                conn.setAutoCommit(false);
                String name1 = rs.getString("name");
                System.out.println(name1 + "|" + rs.getString("position") + "|");
                char var12 = rs.getString("position").charAt(0);
                String pos = "" + var12 + rs.getString("position").charAt(1);
                this.matchesPlayed = rs.getInt("matches_played");
                this.starts = rs.getInt("starts");
                this.minutes = rs.getInt("minutes");
                this.goals = rs.getInt("goals");
                System.out.println("goals");
                System.out.println(goals);
                this.assists = rs.getInt("assists");
                this.penalties = rs.getInt("penalties");
                this.yellows = rs.getInt("yellows");
                this.reds = rs.getInt("reds");
                this.prgC = rs.getInt("prgC");
                this.prgP = rs.getInt("prgP");
                this.prgR = rs.getInt("prgR");
                this.touches = rs.getInt("touches");
                this.touchesAttackingThird = rs.getInt("touches_Attacking_Third");
                this.touchesAttackingBox = rs.getInt("touches_Attacking_Box");
                this.minutesPerMatch = rs.getInt("minutes_Per_Match");
                this.goalsAllowed = rs.getInt("goalsAllowed");
                this.tackles = rs.getInt("tackles");
                this.tacklesWon = rs.getInt("tacklesWon");
                this.defensiveErrors = rs.getInt("defensive_Errors");
                this.shortPassesCompleted = rs.getInt("shortPasses_Completed");
                this.mediumPassesCompleted = rs.getInt("mediumPasses_Completed");
                this.keyPasses = rs.getInt("key_Passes");
                this.passesFinalThird = rs.getInt("passes_Final_Third");
                this.passesBox = rs.getInt("passes_Box");
                this.xG = rs.getDouble("xG");
                this.xAG = rs.getDouble("xAG");
                this.xGA = rs.getDouble("xGA");
                this.shortPassesPercentage = rs.getDouble("shortPasses_Percent");
                this.mediumPassesPercentage = rs.getDouble("mediumPasses_Percent");
                playerId++;
                if (!pos.equals("GK")) {
                    switch (pos) {
                        case "MF" -> this.calcMidfielder(playerId, statement);
                        case "DF" -> this.calcDefender(playerId, statement);
                        case "FW" -> this.calcForward(playerId, conn);
                    }
                }
        }

    }

    private void calcForward(int id, Connection con) throws SQLException, InterruptedException {

        this.scores[id - 1] = 0.0;
        System.out.println(id);


        Statement statement = con.createStatement();
        statement.executeUpdate("UPDATE players SET score = 0 WHERE rowid = " + id);

        // Commit the transaction

    }

    private void calcMidfielder(int id, Statement statement) {

        this.scores[id - 1] = 0.0;
        System.out.println(id);
    }

    public void calcDefender(int id, Statement statement) {



        this.scores[id - 1] = 0.0;
        System.out.println(id);
    }

}
