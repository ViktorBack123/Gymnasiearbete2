package goalies;

import java.sql.*;

public class GoalkeeperAlgorithm {
    private Connection con;
    private ResultSet rs;
    private String[] goalkeeper = {"Matches_played",
            "Starts",
            "minutes",
            "goals_against",
            "SoT_against",
            "saves",
            "save_percent",
            "clean_sheets",
            "penalties_against",
            "savePercent_penalties"};
    private double[] goalkeeper1 = {0.5, 0.5, 0.3, -1, -0.2, 0.4, 0.6, 0.8, -0.4375, 0.5};

    public static void main(String[] args) throws SQLException {
        new GoalkeeperAlgorithm();
    }

    public GoalkeeperAlgorithm(/*String url*/) throws SQLException {
        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel
        this.con = DriverManager.getConnection(url);

        String sql = "SELECT * from goalkeepers";
        Statement statement = this.con.createStatement();
        this.rs = statement.executeQuery(sql);

        int playerId = 0;

        while(rs.next()) {
            playerId++;
            calcScore(playerId, this.goalkeeper);
        }
        this.con.close();
        statement.close();
        rs.close();
    }

    private void calcScore(int playerId, String[] arr) throws SQLException {
        int i = 0;
        double score = 0;

        for (String str: arr) {
            GoalkeeperHighest highest = new GoalkeeperHighest(str);
            double agg = (rs.getDouble(str) - highest.getLowest())/(highest.getHighest() - highest.getLowest());
            score += (agg*goalkeeper1[i]);
            i++;
        }

        Statement statement = this.con.createStatement();
        System.out.println("nr: " + playerId);
        System.out.println(score);
        statement.executeUpdate("UPDATE goalkeepers SET score = " + score + " WHERE rowid = " + playerId);

    }
}
