package fpl.algoritm;

import sqlite.ReadTable;

import java.sql.*;

public class Algoritm extends ReadTable {
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

    @Override
    public void selectAll(){
        String sql = "SELECT name,goals,team FROM playersextra order by goals asc";

        try (Connection conn = ReadTable.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                name = rs.getString("name");
                position = rs.getString("position");
                team = rs.getString("team");
                matchesPlayed = rs.getInt("matches");
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
                touchesAttackingThird = rs.getInt("touchesAttackingThird");
                touchesAttackingBox = rs.getInt("touchesAttackingBox");
                minutesPerMatch = rs.getInt("minutesPerMatch");
                goalsAllowed = rs.getInt("goalsAllowed");
                tackles = rs.getInt("tackles");
                tacklesWon = rs.getInt("tacklesWon");
                defensiveErrors = rs.getInt("defensiveErrors");
                shortPassesCompleted = rs.getInt("shortPassesCompleted");
                mediumPassesCompleted = rs.getInt("mediumPassesCompleted");
                keyPasses = rs.getInt("keyPasses");
                passesFinalThird = rs.getInt("passesFinalThird");
                passesBox = rs.getInt("passesBox");
                xG = rs.getDouble("xG");
                xAG = rs.getDouble("xAG");
                xGA = rs.getDouble("xGA");
                shortPassesPercentage = rs.getDouble("shortPassesPercentage");
                mediumPassesPercentage = rs.getDouble("mediumPassesPercentage");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReadTable.connect();



    }




}
