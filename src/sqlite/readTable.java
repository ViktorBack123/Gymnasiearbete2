package sqlite;

import java.sql.*;

public class readTable {
    private Connection connect() {
        // SQLite's connection string
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT name,URL,team FROM players";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("name") + "|"+
                        rs.getInt("URL") + "|"+
                        rs.getString("team") + "|");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readTable app = new readTable();
        app.selectAll();
    }
}
