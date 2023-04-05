package sqlite;

import java.sql.*;

public class createTable {
    public static void main(String[] args) throws SQLException {
        new createTable();
    }

    public createTable() throws SQLException {
        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);  // sets timeout


        /*statement.executeUpdate(("create table playersExtra(" +
                "name TEXT," +
                "team TEXT," +
                "Matches_Played INTEGER," +
                "Starts INTEGER," +
                "minutes INTEGER," +
                "goals INTEGER," +
                "assists INTEGER," +
                "GnA INTEGER," +
                "nonPenaltiesG INTEGER," +
                "penalties INTEGER," +
                "yellows INTEGER," +
                "reds INTEGER," +
                "xG DECIMAL," +
                "npxg DECIMAL," +
                "xag DECIMAL," +
                "prgc INTEGER," +
                "prgp INTEGER," +
                "prgr INTEGER)"));

        ResultSet rs = statement.executeQuery("select * from fromexcel");

         */

        statement.executeUpdate("create table players(" +
                "name TEXT," +
                "position TEXT," +
                "team TEXT," +
                "matchesPlayed INTEGER," +
                "starts INTEGER," +
                "minutes INTEGER," +
                "goals INTEGER," +
                "assists INTEGER," +
                "penalties INTEGER," +
                "yellows INTEGER," +
                "reds INTEGER," +
                "xG DECIMAL," +
                "xAG DECIMAL," +
                "prgC INTEGER," +
                "prgP INTEGER," +
                "prgR INTEGER," +
                "touches INTEGER," +
                "touchesAttackingThird INTEGER," +
                "touchesAttackingBox INTEGER," +
                "minutesPerMatch INTEGER," +
                "goalsAllowed INTEGER," +
                "xGA DECIMAL," +
                "tackles INTEGER," +
                "tacklesWon INTEGER," +
                "defensiveErrors INTEGER," +
                "shortPassesCompleted INTEGER," +
                "shortPassesPercent DECIMAL," +
                "mediumPassesCompleted INTEGER," +
                "mediumPassesPercent DECIMAL," +
                "keyPasses INTEGER," +
                "passesFinalThird INTEGER," +
                "passesBox INTEGER)");

        // ANVÄND ROWID
    }
}

