package sqlite;

import java.sql.*;

public class createTable {
    public static void main(String[] args) throws SQLException {
        new createTable();
    }

    public createTable() throws SQLException {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

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
                "Matches_Played INTEGER," +
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
                "touches_attacking_third INTEGER," +
                "touches_attacking_box INTEGER," +
                "minutes_per_match INTEGER," +
                "goalsallowed INTEGER," +
                "xGA DECIMAL," +
                "tackles INTEGER," +
                "tacklesWon INTEGER," +
                "defensive_errors INTEGER," +
                "shortpasses_completed INTEGER," +
                "shortpasses_percent DECIMAL," +
                "mediumpasses_completed INTEGER," +
                "mediumpasses_percent DECIMAL," +
                "key_passes INTEGER," +
                "passes_final_third INTEGER," +
                "passes_box INTEGER)");

        // ANVÄND ROWID
    }
}

