package sqlite;

import java.sql.*;

public class ReadTable {
    public static Connection connect() {
        // SQLite's connection string
        // String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the table
     */
    public void selectAll(){
        String sql = "SELECT name,goals,team FROM playersextra order by goals asc";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("name") + "|"+
                        rs.getInt("Goals") + "|"+
                        rs.getString("team") + "|");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        ReadTable app = new ReadTable();
        app.selectAll();
    }
}
