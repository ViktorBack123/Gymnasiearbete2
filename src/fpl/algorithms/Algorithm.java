package fpl.algorithms;

import java.sql.*;
import java.util.ArrayList;

public class Algorithm {

    Connection con;

    ResultSet rs;



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
                        case "MF" -> this.calcMidfielder(playerId);
                        case "DF" -> this.calcDefender(playerId);
                        case "FW" -> this.calcForward(playerId);
                    }
                }
        }

    }

    private void calcForward(int playerId) throws SQLException, InterruptedException {

        //int score = this.rs.getInt("name") + this.rs.getInt("xG");

        int score = 0;


        double goals = rs.getInt("goals");
        int goalsMax = rs.getInt(1);
        System.out.println(goals);

        Statement statement = this.con.createStatement();
        statement.executeUpdate("UPDATE players SET score = "+ score +" WHERE rowid = " + playerId);
        //System.out.println(this.rs.getInt("penalties"));

        // Commit the transaction

    }

    private void calcMidfielder(int playerId) {


    }

    public void calcDefender(int playerId) {

    }

}
