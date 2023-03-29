package fpl.algoritm;

import sqlite.ReadTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    private int shortpassesCompleted;
    private int mediumpassesCompleted;
    private int keyPasses;
    private int passesFinalThird;
    private int passesBox;
    private double xG;
    private double xAG;
    private double xGA;
    private double shortpassesPercentage;
    private double mediumpassesPercentage;


    public Algoritm(String name, String position, String team, int matchesPlayed, int starts, int minutes,
                    int goals, int assists, int penalties, int yellows, int reds, int prgC,
                    int prgP, int prgR, int touches, int touchesAttackingThird, int touchesAttackingBox,
                    int minutesPerMatch, int goalsAllowed, int tackles, int tacklesWon, int defensiveErrors,
                    int shortpassesCompleted, int mediumpassesCompleted, int keyPasses, int passesFinalThird,
                    int passesBox, double xG, double xAG, double xGA, double shortpassesPercentage, double mediumpassesPercentage) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.matchesPlayed = matchesPlayed;
        this.starts = starts;
        this.minutes = minutes;
        this.goals = goals;
        this.assists = assists;
        this.penalties = penalties;
        this.yellows = yellows;
        this.reds = reds;
        this.prgC = prgC;
        this.prgP = prgP;
        this.prgR = prgR;
        this.touches = touches;
        this.touchesAttackingThird = touchesAttackingThird;
        this.touchesAttackingBox = touchesAttackingBox;
        this.minutesPerMatch = minutesPerMatch;
        this.goalsAllowed = goalsAllowed;
        this.tackles = tackles;
        this.tacklesWon = tacklesWon;
        this.defensiveErrors = defensiveErrors;
        this.shortpassesCompleted = shortpassesCompleted;
        this.mediumpassesCompleted = mediumpassesCompleted;
        this.keyPasses = keyPasses;
        this.passesFinalThird = passesFinalThird;
        this.passesBox = passesBox;
        this.xG = xG;
        this.xAG = xAG;
        this.xGA = xGA;
        this.shortpassesPercentage = shortpassesPercentage;
        this.mediumpassesPercentage = mediumpassesPercentage;
    }

    public static void main(String[] args) {
        ReadTable.connect();



    }




}
