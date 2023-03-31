package fpl.algoritm;

import java.sql.*;

public class FPLRanking {

    public static void main(String[] args) {

        // Connect to the SQLite database
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:path/to/fpl_database.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Calculate expected points for a midfielder
        //double expectedPoints = calculateMidfielderExpectedPoints(conn, playerId, cleanSheets, goalsScored, assists, passesCompleted, shotsOnTarget, goalsConceded);
        //System.out.println("Expected points for midfielder: " + expectedPoints);

        // Close the database connection
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double calculateMidfielderExpectedPoints(Connection conn, int playerId, int cleanSheets, int goalsScored, int assists, double passesCompleted, double shotsOnTarget, int goalsConceded) {
        double expectedPoints = 0.0;

        // Retrieve player data from the database
        try {
            String query = "SELECT * FROM midfielders WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, playerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int minutesPlayed = rs.getInt("minutes_played");
                double yellowCards = rs.getDouble("yellow_cards");
                double redCards = rs.getDouble("red_cards");
                double bonusPoints = rs.getDouble("bonus_points");

                // Calculate the expected points based on the algorithm
                expectedPoints = (1 * cleanSheets) + (1 * goalsScored) + (3 * assists) + (0.02 * passesCompleted) + (0.05 * shotsOnTarget) - (1 * goalsConceded) + (0.01 * minutesPlayed) - (1 * yellowCards) - (2 * redCards) + bonusPoints;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return expectedPoints;
    }
}





