package fpl.algorithms;

import java.sql.*;

public class Algorithm {
    private Connection con;
    private ResultSet rs;
    private String[] forward = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgR", "touchesAttackingBox", "keyPasses"};
    private double[] forwardWeights = {0.1, 0.1, 0.1, 1, 0.75, 0.375, -0.25, -0.75, 0.2, 0.15, 0.2, 0.2, 0.2};
    private String[] midfielder = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgC", "prgP", "prgR", "touchesAttackingThird", "touchesAttackingBox", "goalsAllowed", "xGA", "keyPasses", "passesBox"};
    private double[] midfielderWeights = {0.1, 0.1, 0.1, 1, 0.6, 0.35, -0.3, -0.8, 0.15, 0.2, 0.1, 0.2, 0.1, 0.2, 0.1, -0.2, -0.1, 0.3, 0.2};
    private String[] defender = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgC", "prgP", "prgR", "touches", "touchesAttackingThird", "touchesAttackingBox", "goalsAllowed", "xGA",  "tacklesWon", "defensiveErrors", "shortPassesCompleted", "shortPassesPercent", "mediumPassesCompleted", "mediumPassesPercent", "keyPasses", "passesFinalThird", "passesBox"};
    private double[] defenderWeights = {0.15, 0.15, 0.2, 1, 0.5, 0.33, -0.3, -0.8, 0.15, 0.2, 0.15, 0.15, 0.15, 0.1, 0.2, 0.2, -0.66, -0.33, 0.15, -0.2, 0.1, 0.05, 0.15, 0.075, 0.1, 0.05, 0.2, 0.1, 0.2};

    public static void main(String[] args) throws SQLException {
        new Algorithm();
    }

    public Algorithm() throws SQLException {
        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel
        this.con = DriverManager.getConnection(url);

        String sql = "SELECT * from players";
        Statement statement = this.con.createStatement();
        this.rs = statement.executeQuery(sql);

        int playerId = 0;
        while(this.rs.next()) {
                playerId++;
                char var12 = rs.getString("position").charAt(0);
                String pos = "" + var12 + this.rs.getString("position").charAt(1);
                if (!pos.equals("GK")) {
                    switch (pos) {
                        case "DF" -> calcScore(playerId, this.defender, this.defenderWeights);
                        case "MF" -> calcScore(playerId, this.midfielder, this.midfielderWeights);
                        case "FW" -> calcScore(playerId, this.forward, this.forwardWeights);
                    }
                }
        }

    }

    private void calcScore(int playerId, String[] arr, double[] weights) throws SQLException {
        int i = 0;
        double score = 0;

        for (String str: arr) {
            Highest highest = new Highest(str);
            double agg = (this.rs.getDouble(str) - highest.getLowest())/(highest.getHighest() - highest.getLowest());
            score += (agg*weights[i]);
            i++;
        }

        Statement statement = this.con.createStatement();
        statement.executeUpdate("UPDATE players SET score = " + score + " WHERE rowid = " + playerId);
    }



}
