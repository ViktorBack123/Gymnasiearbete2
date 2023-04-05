package fpl.algoritm;

import fpl.algorithms.Highest;

import java.sql.*;
import java.util.ArrayList;

public class Algoritm {
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

    private int playerId;

    public Algoritm(ArrayList<String> list) {
        list.add("matchesPlayed");
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
        list.add("touchesAttackingThird");
        list.add("touchesAttackingBox");
        list.add("minutesPerMatch");
        list.add("goalsAllowed");
        list.add("xGA");
        list.add("tackles");
        list.add("tacklesWon");
        list.add("defensiveErrors");
        list.add("shortPassesCompleted");
        list.add("shortPassesPercent");
        list.add("mediumPassesCompleted");
        list.add("mediumPassesPercent");
        list.add("keyPasses");
        list.add("passesFinalThird");
        list.add("passesBox");

    }

    public void databse(){
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db";
        String sql = "SELECT * from players";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                this.name = rs.getString("name");
                this.position = rs.getString("position");
                this.team = rs.getString("team");
                this.matchesPlayed = rs.getInt("matches");
                this.starts = rs.getInt("starts");
                this.minutes = rs.getInt("minutes");
                this.goals = rs.getInt("goals");
                this.assists = rs.getInt("assists");
                this.penalties = rs.getInt("penalties");
                this.yellows = rs.getInt("yellows");
                this.reds = rs.getInt("reds");
                this.prgC = rs.getInt("prgC");
                this.prgP = rs.getInt("prgP");
                this.prgR = rs.getInt("prgR");
                this.touches = rs.getInt("touches");
                this.touchesAttackingThird = rs.getInt("touchesAttackingThird");
                this.touchesAttackingBox = rs.getInt("touchesAttackingBox");
                this.minutesPerMatch = rs.getInt("minutesPerMatch");
                this.goalsAllowed = rs.getInt("goalsAllowed");
                this.tackles = rs.getInt("tackles");
                this.tacklesWon = rs.getInt("tacklesWon");
                this.defensiveErrors = rs.getInt("defensiveErrors");
                this.shortPassesCompleted = rs.getInt("shortPassesCompleted");
                this.mediumPassesCompleted = rs.getInt("mediumPassesCompleted");
                this.keyPasses = rs.getInt("keyPasses");
                this.passesFinalThird = rs.getInt("passesFinalThird");
                this.passesBox = rs.getInt("passesBox");
                this.xG = rs.getDouble("xG");
                this.xAG = rs.getDouble("xAG");
                this.xGA = rs.getDouble("xGA");
                this.shortPassesPercentage = rs.getDouble("shortPassesPercentage");
                this.mediumPassesPercentage = rs.getDouble("mediumPassesPercentage");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args)  {
            ArrayList<String> list = new ArrayList<>();
            Algoritm algoritm = new Algoritm(list);
            ArrayList<Highest> parameters = new ArrayList();
        try {
            for (int i = 0; i < list.size(); ++i) {
                parameters.add(new Highest((String) list.get(i)));
                ((Highest) parameters.get(i)).print();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        algoritm.databse();








    }




}
