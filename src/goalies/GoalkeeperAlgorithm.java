package goalies;

import fpl.algorithms.Algorithm;
import fpl.algorithms.Highest;

import java.sql.*;

public class GoalkeeperAlgorithm {
    Connection con;

    ResultSet rs;

    String[] goalie = {"Matches_played",
            "Starts",
            "minutes",
            "goals_against",
            "SoT_against",
            "saves",
            "save_percent",
            "clean_sheets",
            "penalties_against",
            "savePercent_penalties"};



    public static void main(String[] args) throws SQLException, InterruptedException {
        new GoalkeeperAlgorithm();
    }

    public GoalkeeperAlgorithm(/*String url*/) throws SQLException, InterruptedException {

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        //String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db";
        String sql = "SELECT * from goalkeepers";
        this.con = DriverManager.getConnection(url);
        Statement statement = this.con.createStatement();
        this.rs = statement.executeQuery(sql);

        int playerId = 0;

        while(rs.next()) {
            playerId++;

            calcScore(playerId,goalie);
        }

    }

    private void calcScore(int playerId, String[] arr) throws SQLException, InterruptedException {
        double score = 0;
        double k = 0.7;

        for (String str: arr) {
            GoalkeeperHighest highest = new GoalkeeperHighest(str);
            double agg = (rs.getDouble(str)-highest.getLowest())/(highest.getHighest()-highest.getLowest());
            if (str.equals("penalties_against")|str.equals("goals_against")|str.equals("SoT_against"))
                score -= (agg*k);
            else
                score += (agg*k);
        }
        Statement statement = this.con.createStatement();
        System.out.println("nr: " + playerId);
        System.out.println(score);
        statement.executeUpdate("UPDATE goalkeepers SET score = "+ score +" WHERE rowid = " + playerId);

    }
}
