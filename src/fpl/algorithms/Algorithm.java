package fpl.algorithms;

import java.sql.*;

public class Algorithm {

    Connection con;

    ResultSet rs;

    String[] forward = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgC", "prgP", "prgR", "touches", "touchesAttackingThird", "touchesAttackingBox", "minutesPerMatch", "goalsAllowed", "xGA", "tackles", "tacklesWon", "defensiveErrors", "shortPassesCompleted", "shortPassesPercent", "mediumPassesCompleted", "mediumPassesPercent", "keyPasses", "passesFinalThird", "passesBox"};
    String[] midfielder = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgC", "prgP", "prgR", "touches", "touchesAttackingThird", "touchesAttackingBox", "minutesPerMatch", "keyPasses", "passesFinalThird", "passesBox"};
    String[] defender = {"matchesPlayed", "starts", "minutes", "goals", "assists", "penalties", "yellows", "reds", "xG", "xAG", "prgC", "prgP", "prgR", "touches", "touchesAttackingThird", "touchesAttackingBox", "minutesPerMatch", "keyPasses", "passesFinalThird", "passesBox"};




    public static void main(String[] args) throws SQLException, InterruptedException {
        new Algorithm();
    }

    public Algorithm(/*String url*/) throws SQLException, InterruptedException {

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        //String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db";
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
                        case "MF" -> this.calcScore(playerId, forward);
                        case "DF" -> this.calcScore(playerId, forward);
                        case "FW" -> this.calcScore(playerId, forward);
                    }
                }
        }

    }

    private void calcScore(int playerId, String[] arr) throws SQLException, InterruptedException {
        double score = 0;
        double k = 0.2;

        for (String str: arr) {
            Highest highest = new Highest(str);
            double agg = (rs.getDouble(str)-highest.getLowest())/(highest.getHighest()-highest.getLowest());
            System.out.println(agg);
            if (str.equals("yellows") | str.equals("reds") | str.equals("goalsAllowed") | str.equals("xGA") | str.equals("defensiveErrors"))
                score -= (agg*k);
            else
                score += (agg*k);
        }


        // score = this.rs.getInt("goals") + this.rs.getInt("xG");


        //int score = 0;
        Statement statement = this.con.createStatement();
        statement.executeUpdate("UPDATE players SET score = "+ score +" WHERE rowid = " + playerId);
        //System.out.println(this.rs.getInt("penalties"));

        // Commit the transaction

    }



}
