package fpl.algorithms;

import java.sql.*;

public class Algorithm {

    Connection con;

    ResultSet rs;

    String[] allStats = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgC", "prgP", "prgR", "touches", "touchesAttackingThird", "touchesAttackingBox", "minutesPerMatch", "goalsAllowed", "xGA", "tackles", "tacklesWon", "defensiveErrors", "shortPassesCompleted", "shortPassesPercent", "mediumPassesCompleted", "mediumPassesPercent", "keyPasses", "passesFinalThird", "passesBox"};
    String[] forward = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgR", "touchesAttackingBox", "keyPasses"};
    double[] forward1 = {0.1, 0.1, 0.1, 1, 0.75, 0.375, -0.25, -0.75, 0.2, 0.15, 0.2, 0.2, 0.2};
    //2,075
    String[] midfielder = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgC", "prgP", "prgR", "touchesAttackingThird", "touchesAttackingBox", "goalsAllowed", "xGA", "keyPasses", "passesBox"};
    double[] midfielder1 = {0.1, 0.1, 0.1, 1, 0.6, 0.35, -0.3, -0.8, 0.15, 0.2, 0.1, 0.2, 0.1, 0.2, 0.1, -0.2, -0.1, 0.3, 0.2};
    //2,125
    String[] defender = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgC", "prgP", "prgR", "touches", "touchesAttackingThird", "touchesAttackingBox", "goalsAllowed", "xGA",  "tacklesWon", "defensiveErrors", "shortPassesCompleted", "shortPassesPercent", "mediumPassesCompleted", "mediumPassesPercent", "keyPasses", "passesFinalThird", "passesBox"};
    double[] defender1 = {0.15, 0.15, 0.2, 1, 0.5, 0.33, -0.3, -0.8, 0.15, 0.2, 0.15, 0.15, 0.15, 0.1, 0.2, 0.2, -0.66, -0.33, 0.15, -0.2, 0.1, 0.05, 0.15, 0.075, 0.1, 0.05, 0.2, 0.1, 0.2};





    public static void main(String[] args) throws SQLException, InterruptedException {
        new Algorithm();
    }

    public Algorithm(/*String url*/) throws SQLException, InterruptedException {

        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db";
        String sql = "SELECT * from players";
        this.con = DriverManager.getConnection(url);
        Statement statement = this.con.createStatement();
        this.rs = statement.executeQuery(sql);

        int playerId = 0;

        while(rs.next()) {
                playerId++;

                char var12 = rs.getString("position").charAt(0);
                String pos = "" + var12 + rs.getString("position").charAt(1);
                if (!pos.equals("GK")) {
                    switch (pos) {
                        case "DF" -> this.calcScore(playerId, defender, defender1);
                        case "MF" -> this.calcScore(playerId, midfielder, midfielder1);
                        case "FW" -> this.calcScore(playerId, forward, forward1);
                    }
                }
        }

    }

    private void calcScore(int playerId, String[] arr, double[] weights) throws SQLException, InterruptedException {
        int i = 0;
        double score = 0;


        for (String str: arr) {
            Highest highest = new Highest(str);
            double agg = (rs.getDouble(str)-highest.getLowest())/(highest.getHighest()-highest.getLowest());
            System.out.println(agg);
            score += (agg*weights[i]);
            i++;
        }


        // score = this.rs.getInt("goals") + this.rs.getInt("xG");


        //int score = 0;
        Statement statement = this.con.createStatement();
        statement.executeUpdate("UPDATE players SET score = "+ score +" WHERE rowid = " + playerId);
        //System.out.println(this.rs.getInt("penalties"));

        // Commit the transaction

    }



}
