package sqlite;

import java.sql.*;

public class dropTable {
    public static void main(String[] args) throws SQLException {
        new dropTable();
    }
    public dropTable() throws SQLException {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        // String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);  // sets timeout

        statement.executeUpdate("drop table players");
    }
}
