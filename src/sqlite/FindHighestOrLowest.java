package sqlite;

import java.sql.*;

public class FindHighestOrLowest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);  // sets timeout

        ResultSet rs = statement.executeQuery("select MAX(goals) from players");
        System.out.println(rs.getString(1));
        rs = statement.executeQuery("select max(xG) from players");
        System.out.println(rs.getDouble(1));
    }
}
