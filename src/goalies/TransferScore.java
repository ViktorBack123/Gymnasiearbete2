package goalies;

import java.sql.*;

public class TransferScore {
    public static void main(String[] args) throws SQLException {
        new TransferScore();
    }

    Connection con;

    ResultSet rs;
    public TransferScore() throws SQLException {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        //String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db";
        String sql = "SELECT * from goalkeepers";
        this.con = DriverManager.getConnection(url);
        Statement statement = this.con.createStatement();
        this.rs = statement.executeQuery(sql);

        String name;
        String sql2;
        while (rs.next()){
            name=rs.getString("name");
            sql2 = "UPDATE players SET score = " + rs.getDouble("score") + " WHERE name = '" + name+"'";
            System.out.println(sql2);

            statement=con.createStatement();
            statement.executeUpdate(sql2);
        }
    }
}
